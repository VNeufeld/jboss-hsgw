package com.bpcs.suny.tool.tdva;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 * @author Markus Siegel
 */
public class StringUtils
{

	/**
	 * 
	 */
	public static final int    DDMMYY	      = 0;

	/**
	 * 
	 */
	public static final int    DDMMYYYY	    = 1;

	/**
	 * 
	 */
	public static final int    DD_MM_YYYY	  = 2;

	/**
	 * 
	 */
	public static final int    YYYY_MM_DD	  = 3;

	/**
	 * 
	 */
	public static final int    HHmmSS	      = 4;

	/**
	 * 
	 */
	public static final int    HH_mm_SS	    = 5;

	/**
	 * 
	 */
	public static final int    HHmm		= 6;

	/**
	 * 
	 */
	public static final int    HH_mm	       = 7;

	/**
	 * 
	 */
	public static final int    HH_mm_SS_ccc	= 8;

	/**
	 * 
	 */
	public static final String VALID_CHARS_ALPHA   = "A-Za-z";

	/**
	 * 
	 */
	public static final String VALID_CHARS_NUMERIC = "+\\-0-9";

	/**
	 * 
	 */
	public static Logger       LOG		 = Logger
	.getLogger(StringUtils.class);

	/**
	 * @param pString
	 * @param pAddString
	 * @param pDelimiter
	 * @return String
	 */
	public static String add(String pString, String pAddString,
			String pDelimiter)
	{
		if (pString != null && !pString.equals(""))
		{
			pString += pDelimiter + pAddString;
		}
		else
		{
			pString = pAddString;
		}
		return pString;
	}

	/**
	 * @param pString
	 * @param pAddString
	 * @return String
	 */

	public static String addComma(String pString, String pAddString)
	{

		return add(pString, pAddString, ",");
	}

	public static String addCommaSpace(String pString, String pAddString)
	{

		return add(pString, pAddString, ", ");
	}

	/**
	 * @param pString
	 * @param pAddString
	 * @return String
	 */
	public static String addSpace(String pString, String pAddString)
	{

		return add(pString, pAddString, " ");
	}

	/**
	 * @param pValue
	 * @param pValidValues
	 * @return String
	 */
	public static String checkValidity(int pValue, List pValidValues)
	{
		return checkValidity("" + pValue, pValidValues);
	}

	/**
	 * @param pValue
	 * @param pValidValues
	 * @return String
	 */
	public static String checkValidity(String pValue, List pValidValues)
	{
		if (pValidValues != null && pValidValues.contains(pValue))
		{
			return pValue;
		}

		return "";
	}

	/**
	 * @param pString
	 * @param pCodeMap
	 * @return String
	 */
	public static String decode(String pString, Map pCodeMap)
	{
		String sDecodeString = "";
		if (pString != null && pCodeMap != null)
		{
			sDecodeString = pString;
			for (Iterator iter = pCodeMap.keySet().iterator(); iter.hasNext();)
			{
				String key = (String) iter.next();
				String code = (String) pCodeMap.get(key);
				sDecodeString = sDecodeString.replaceAll(code, key);
			}
		}

		return sDecodeString;
	}

	/**
	 * Returns a String that represents the Collection with two kind of
	 * delimiters <code>"-"</code> and <code>","</code>;<br>
	 * <i>Example:
	 * <code>Collection  as input [1,3,4,5,9], output String "1,3-5,9"</code></i>
	 * 
	 * @param pColl
	 *                the Collection to delimit
	 * @param pbValuesGreaterEqualZero
	 * @return a <code>String</code> that contains the elements of the
	 *         Collection with delimites.
	 */
	public static String delimitCollection(Collection pColl,
			boolean pbValuesGreaterEqualZero)
	{
		if (pColl == null || pColl.size() == 0)
		{
			return "";
		}

		StringBuffer sb = new StringBuffer(16);
		int i = 0;
		int last = 0;
		int current = -1;
		boolean bUntilIsOpen = false;
		for (Iterator iter = pColl.iterator(); iter.hasNext(); i++)
		{
			current = toInt((String) iter.next());
			if (pbValuesGreaterEqualZero && current < 0)
			{

				LOG.error("Delimit values lower Zero");

			}
			else
			{
				if (i == 0)
				{
					sb.append(current);
					last = current;
					continue;
				}
				if (last + 1 == current)
				{
					if (!iter.hasNext())
					{
						sb.append("-" + current);
					}
					else
					{
						last = current;
						bUntilIsOpen = true;
					}
				}
				else
				{
					// msi#084 also when new iter
					if (bUntilIsOpen)
					{
						bUntilIsOpen = false;
						sb.append("-" + last);
					}
					sb.append("," + current);
					last = current;
				}
			}

		}

		return sb.toString();
	}

	/**
	 * @param pColl
	 * @param delimiter
	 * @return String
	 */
	public static String delimitCollection(Collection pColl, String delimiter)
	{
		String s = "";

		Iterator it = pColl.iterator();

		while (it.hasNext())
		{
			s += delimiter + it.next();
		}

		if (s.startsWith(delimiter))
		{
			s = s.substring(1);
		}

		return s;
	}

	/**
	 * @param pColl
	 * @param delimiter
	 * @param quote
	 * @return String
	 */
	public static String delimitCollection(Collection pColl, String delimiter,
			boolean quote)
	{
		String s = "";
		String temp = null;

		Iterator it = pColl.iterator();

		while (it.hasNext())
		{
			temp = (String) it.next();

			if (!"".equals(trimNull(temp)))
			{
				if (quote)
				{
					s += delimiter + "'" + temp + "'";
				}
				else
				{
					s += delimiter + temp;
				}
			}
		}

		if (s.startsWith(delimiter))
		{
			s = s.substring(1);
		}

		return s;
	}

	/**
	 * @param pString
	 * @param pCodeMap
	 * @return String
	 */
	public static String encode(String pString, Map pCodeMap)
	{
		String sEncodeString = "";
		if (pString != null && pCodeMap != null)
		{
			sEncodeString = pString;
			for (Iterator iter = pCodeMap.keySet().iterator(); iter.hasNext();)
			{
				String key = (String) iter.next();
				String code = (String) pCodeMap.get(key);
				sEncodeString = sEncodeString.replaceAll(key, code);
			}
		}

		return sEncodeString;
	}

	/**
	 * @param s
	 * @param def
	 * @return String
	 */
	public static String fillIfEmpty(String s, String def)
	{
		if (s == null || "".equals(s.trim()))
		{
			s = def;
		}
		return s;
	}

	/**
	 * @param pNumOfSpaces
	 * @return String
	 */
	public static String getSpaces(String pNumOfSpaces)
	{
		String spaces = "";

		for (int i = 0; i < Integer.parseInt(pNumOfSpaces); i++)
		{
			spaces += " ";
		}

		return spaces;
	}

	/**
	 * @param s
	 * @return boolean
	 */
	public static boolean isAllEmptyOrNull(String[] s)
	{
		boolean b = true;

		for (int i = 0; i < s.length; i++)
		{
			if (trimNull(s[i]).trim().length() > 0)
			{
				return false;
			}
		}

		return b;
	}

	/**
	 * @param s
	 * @return boolean
	 */
	public static boolean isNullorEmpty(String s)
	{
		return s == null || "".equals(s.trim());
	}

	/**
	 * @param pString
	 * @param pLength
	 * @param pDelimiter
	 * @return String
	 */
	public static String limitLength(String pString, int pLength,
			String pDelimiter)
	{
		Iterator it;
		List l = Arrays.asList(pString.split(pDelimiter));
		String s = "";

		while (l.size() > 0)
		{
			s = "";

			it = l.iterator();

			while (it.hasNext())
			{
				s += "" + it.next();
			}

			if (s.length() > pLength)
			{
				if (l.size() > 1)
				{
					l = l.subList(1, l.size());
				}
				else
				{
					s = "" + l.get(0);
					break;
				}
			}
			else
			{
				break;
			}
		}

		if (!"".equals(s))
		{
			pString = s;
		}

		return StringUtils.setToLength(pString, " ", pLength, true).trim();
	}

	/**
	 * @param pHtml
	 * @return String
	 */
	public static String releaseHTMLBreaks(String pHtml)
	{
		String s = "";

		return s;
	}


	/**
	 * @param s
	 * @param def
	 * @return String
	 */
	public static String replaceNull(String s, String def)
	{
		if (s == null)
		{
			s = def;
		}
		return s;
	}

	/**
	 * @param pString
	 * @param pReplace
	 * @param pStart
	 * @param pEnd
	 * @return String
	 */
	public static String replaceStringPart(String pString, String pReplace,
			int pStart, int pEnd)
	{
		String temp1 = pString.substring(0, pStart);
		String temp2 = pString.substring(pEnd, pString.length());

		return temp1 + pReplace + temp2;
	}


	public static String padLeft(String psStringToPad, int piLength, char pchPadChar){
		String sPadding = buildString(pchPadChar, piLength);

		psStringToPad = sPadding + psStringToPad;

		int iStringLen = psStringToPad.length();

		return psStringToPad.substring(iStringLen-piLength, iStringLen);
	}

	public static String buildString(char ch, int length){
		char newStr[] = new char[length];

		for(int i=0;i<length;++i) {
			newStr[i]=ch;
		}

		return new String(newStr);
	}

	/**
	 * @param pName
	 * @param pValue
	 * @param pRequired
	 * @param pReqLength
	 * @return String
	 */
	public static String setAttribute(String pName, String pValue,
			boolean pRequired, int pReqLength)
	{
		String s = "";

		if (pRequired || pValue.length() > 0 && pValue != null)
		{
			if (pReqLength > 0)
			{
				pValue = setToLength(pValue, " ", pReqLength, true);
			}
			s = pName + "=\"" + pValue + "\"";
		}

		return s;
	}

	/**
	 * @param s
	 * @param spaces
	 * @return String
	 */
	public static String setLine(String[] s, int[] spaces)
	{
		return setLine(s, spaces, true);
	}

	/**
	 * @param s
	 * @param spaces
	 * @param pAppendRight
	 * @return String
	 */
	public static String setLine(String[] s, int[] spaces, boolean pAppendRight)
	{
		String sLine = "";

		for (int i = 0; i < s.length; i++)
		{
			if (spaces.length > i)
			{
				sLine += StringUtils.setToLength(s[i], " ", spaces[i],
						pAppendRight);
			}
			else
			{
				sLine += " " + s[i];
			}
		}

		return sLine;
	}

	/**
	 * Sets the String pContent to the length pLength. If the length of the
	 * pContent more than pLength, pContent will be cuted, if less, than
	 * pContent will be alnged by adding of the String pBuffer. If pSide is
	 * true, than pBuffer will be added on the end of the pContent String, if
	 * false - on the beging
	 * 
	 * @param pContent
	 *                the String to be seted
	 * @param pBuffer
	 *                the String to add to pContend untill pContend has the wish
	 *                length
	 * @param pLength
	 *                the wish length for pContent
	 * @param pSide
	 *                true if pBuffer has to be added on the end of the pContent
	 *                String
	 * @return pContent with the length pLength
	 */
	public static String setToLength(String pContent, String pBuffer, int pLength, boolean pSide)
	{
		pContent = trimNull(pContent);

		if (pContent.length() > pLength)
		{
			pContent = pContent.substring(0, pLength).trim();
		}

		while (pContent.length() < pLength)
		{
			if (pSide)
			{
				pContent += pBuffer;
			}
			else
			{
				pContent = pBuffer + pContent;
			}
		}

		return pContent;
	}

	/**
	 * Fill String up to lengt and cut if to Long
	 * 
	 * @param pContent
	 * @param pFiller
	 * @param pLength
	 * @param pbFillRightSide
	 * @param pbCutFromRight
	 * @return String
	 */
	public static String setToLength(String pContent, String pFiller,
			int pLength, boolean pbFillRightSide, boolean pbCutFromRight)
	{
		pContent = trimNull(pContent);

		if (pContent.length() > pLength)
		{
			if (pbCutFromRight)
			{
				pContent = pContent.substring(0, pLength).trim();

			}
			else
			{
				pContent = pContent.substring(pContent.length() - pLength,
						pLength).trim();
			}

		}

		while (pContent.length() < pLength)
		{
			if (pbFillRightSide)
			{
				pContent += pFiller;
			}
			else
			{
				pContent = pFiller + pContent;
			}
		}

		return pContent;
	}

	/**
	 * Sets the String pContent to the length pLength if pContent is not empty
	 * String. If the length of the pContent more than pLength, pContent will be
	 * cuted, if less, than pContent will be alnged by adding of the String
	 * pBuffer, if "0", than pContent stays empty. If pSide is true, than
	 * pBuffer will be added on the end of the pContent String, if false - on
	 * the beging
	 * 
	 * @param pContent
	 *                the String to be seted
	 * @param pBuffer
	 *                the String to add to pContend untill pContend has the wish
	 *                length
	 * @param pLength
	 *                the wish length for pContent
	 * @param pSide
	 *                true if pBuffer has to be added on the end of the pContent
	 *                String
	 * @return pContent with the length pLength
	 */
	public static String setToLengthOrEmpty(String pContent, String pBuffer,
			int pLength, boolean pSide)
	{
		pContent = trimNull(pContent);
		if (pContent.length() > pLength)
		{
			pContent = pContent.substring(0, pLength);
		}
		else if (pContent.length() > 0)
		{
			while (pContent.length() < pLength)
			{
				if (pSide)
				{
					pContent += pBuffer;
				}
				else
				{
					pContent = pBuffer + pContent;
				}
			}
		}
		return pContent;
	}


	/**
	 * Cuts a string into pieces of a defined length
	 * 
	 * @param pInfo
	 * @param piRowLength
	 * @return List
	 */
	public static List splitToLength(String pInfo, int piRowLength)
	{
		List list = new LinkedList();

		for (int i = 0; i < pInfo.length(); i += piRowLength)
		{
			if (i + piRowLength > pInfo.length())
			{
				piRowLength = pInfo.length() - i;
			}

			list.add(pInfo.substring(i, i + piRowLength));
		}

		return list;
	}

	/**
	 * Generates a comma seperated price without currency
	 * 
	 * @param pDouble
	 *                A price value
	 * @return A price
	 */
	public static String toCurrency(double pDouble)
	{

		return toCurrency(pDouble, true, true, false, Locale.GERMANY);
	}

	/**
	 * Generates a comma seperated exchange rate.
	 * 
	 * @param pDouble
	 *                A price value
	 * @return A price
	 */
	public static String toCurrencyExchangeRate(double pDouble){
		return toCurrency(pDouble, true, true, false, Locale.GERMANY, 4);
	}

	// msi#112 new function
	/**
	 * @param pDouble
	 * @param pFractions
	 * @param pGrouping
	 * @return String
	 */
	public static String toCurrency(double pDouble, boolean pFractions,
			boolean pGrouping)
	{

		return toCurrency(pDouble, pFractions, pGrouping, false, Locale.GERMANY);
	}

	/**
	 * 
	 * @param pDouble
	 * @param pFractions
	 * @param pGroupings
	 * @param pCurrency
	 * @param pLocale
	 * @param defaultFractionDigits
	 * @return
	 */
	public static String toCurrency(double pDouble, boolean pFractions,
			boolean pGroupings, boolean pCurrency, Locale pLocale, 
			int defaultFractionDigits)
	{
		String sReturn = "";
		String sCurrency = "EUR";
		NumberFormat form;

		form = NumberFormat.getInstance(pLocale);

		if (form instanceof DecimalFormat)
		{
			if (!pGroupings)
			{
				((DecimalFormat) form).setGroupingUsed(false);
			}

			if (pFractions)
			{
				((DecimalFormat) form).setDecimalSeparatorAlwaysShown(true);
				((DecimalFormat) form).setMaximumFractionDigits(defaultFractionDigits);
				((DecimalFormat) form).setMinimumFractionDigits(defaultFractionDigits);
			}
			else
			{
				((DecimalFormat) form).setDecimalSeparatorAlwaysShown(false);
				((DecimalFormat) form).setMaximumFractionDigits(0);
				((DecimalFormat) form).setMinimumFractionDigits(0);
			}
		}

		sReturn = form.format(pDouble);
		if (pCurrency)
		{
			sReturn += " " + sCurrency;
		}
		return sReturn;
	}

	/**
	 * @param pDouble
	 * @param pFractions *
	 * @param pGroupings
	 * @param pCurrency
	 * @param pLocale
	 * @return String
	 */
	public static String toCurrency(double pDouble, boolean pFractions,
			boolean pGroupings, boolean pCurrency, Locale pLocale)
	{
		// Default fraction digits is 2
		int defaultFractionDigits = 2;
		NumberFormat form = NumberFormat.getInstance(pLocale);

		if (form instanceof DecimalFormat)
		{
			defaultFractionDigits = ((DecimalFormat) form).getCurrency().getDefaultFractionDigits();
		}

		return toCurrency(pDouble, pFractions, pGroupings, pCurrency, pLocale, defaultFractionDigits);
	}

	/**
	 * Generates a price with currency
	 * 
	 * @param pDouble
	 *                A price value
	 * @param pLocale
	 *                A locale
	 * @return A price + currency
	 */
	public static String toCurrency(double pDouble, Locale pLocale)
	{

		return toCurrency(pDouble, true, true, false, pLocale);
	}

	/**
	 * Generates a price with currency
	 * 
	 * @param pDouble
	 *                A price value
	 * @param pLocale
	 *                A locale
	 * @return A price + currency
	 */
	public static String toCurrency(double pDouble, String pLocale)
	{
		Locale locale = null;

		if ("en".equals(pLocale))
		{
			locale = Locale.UK;
		}
		else
		{
			locale = Locale.GERMANY;
		}

		return toCurrency(pDouble, true, true, true, locale);
	}

	/**
	 * Generates a price with currency
	 * 
	 * @param pDouble
	 *                A price value
	 * @param pLocale
	 *                A locale
	 * @return A price + currency
	 */
	public static String toCurrency(String pDouble, Locale pLocale)
	{
		return toCurrency(toDouble(pDouble), pLocale);
	}

	/**
	 * Generates a comma seperated string price without currency
	 * 
	 * @param pString
	 *                A price value
	 * @return A price
	 */
	public static String toCurrencyFormat(String pString)
	{
		return toCurrency(toDouble(pString));
	}

	/**
	 * Generates a double FROM a currency string. Fraction seperator FROM ',' to
	 * '.'
	 * 
	 * @param pString
	 * @return The double
	 */
	public static double toDouble(String pString)
	{
		try
		{
			StringTokenizer st = new StringTokenizer(pString.trim(), " ");
			pString = st.nextToken();
			if (pString.indexOf(",") > 0)
			{
				pString = pString.replaceAll("\\.", "");
			}
			pString = pString.replace(',', '.');
			return Double.parseDouble(pString);
		}
		catch (Exception e)
		{
			return 0.0;
		}
	}

	/**
	 * @param pString
	 * @return int
	 */
	public static int toInt(String pString)
	{
		return toInt(pString, -1);
	}

	/**
	 * @param pString
	 * @param piDefault
	 * @return int
	 */
	public static int toInt(String pString, int piDefault)
	{
		try
		{
			return Integer.parseInt(pString);
		}
		catch (Exception e)
		{
			return piDefault;
		}
	}


	/**
	 * @param pString
	 * @return integer
	 */
	public static Integer toInteger(String pString)
	{
		try
		{
			return new Integer(pString);
		}
		catch (Exception e)
		{
			return new Integer(-1);
		}
	}

	/**
	 * @param pString
	 * @return int
	 */
	public static int toIntZero(String pString)
	{
		return toInt(pString, 0);
	}

	/**
	 * @param s
	 * @return String
	 */
	public static String trimNull(String s)
	{

		if (s == null || "null".equals(s))
		{
			s = "";
		}
		return s;
	}

	/**
	 * @param pXml
	 * @return String
	 */

	public static String XMLdecode(String pXml)
	{
		pXml = pXml.replaceAll("&amp;", "&");
		pXml = pXml.replaceAll("&lt;", "<");
		pXml = pXml.replaceAll("&gt;", ">");
		pXml = pXml.replaceAll("&quot;", "\"");
		pXml = pXml.replaceAll("&apos;", "'");

		return pXml;
	}

	/**
	 * @param pXml
	 * @return String
	 */
	public static String XMLencode(String pXml)
	{
		pXml = trimNull(pXml);

		pXml = pXml.replaceAll("&", "&amp;");
		pXml = pXml.replaceAll("<", "&lt;");
		pXml = pXml.replaceAll(">", "&gt;");
		pXml = pXml.replaceAll("\"", "&quot;");
		pXml = pXml.replaceAll("'", "&apos;");

		return pXml;
	}

	/**
	 *  Inserts delimiter after each maxlength chars without
	 *  splitting html-tags. The lines regular text neither contains the lt-token
	 *  nor the gt-token. This tokens must be encoded when they are needed.
	 *  When BLANCs are found in text, a berak is inserted here.
	 * @param line - the line where delimiter shall be inserted
	 * @param lt - Token that opens a tag
	 * @param gt - Token that closes a tag
	 * @return String with inserted line delimiter tags. When opening tokens
	 * and closing tokens does't match, no replacement is done.
	 */
	public static String insertBreaks(String line, int maxLength, String delimiter, String lt, String gt)
	{
		String result = line;
		int brPos = 0;
		int blancPos = 0;
		int lastPos = -1;
		int opencount = 0;
		int charcount = 0;
		int breakcount = 1;
		boolean inserted = false;
		for(int i = 0; i < result.length(); i++)
		{
			String part1 = result.substring(0, i);
			String part2 = result.substring(i);
			if(part1.endsWith(delimiter) && !inserted)
			{
				charcount = 0;// existing line break: reset charcount
				breakcount = 1;
			}
			if(part2.toLowerCase().startsWith(lt))
			{
				opencount++;
				i += lt.length() - 1;
			}
			else
			{
				if(part2.toLowerCase().startsWith(gt))
				{
					opencount--;
					i += gt.length() - 1;
				}
				else
				{

					if(opencount == 0)
					{
						charcount++;
						lastPos = brPos;
						brPos = i;
						if(part2.toLowerCase().startsWith(" "))
						{
							// lastBlanc = blancPos;
							blancPos = i + 1;// break after BLANC
						}
					}
					inserted = false;
					if(charcount > maxLength * breakcount)
					{
						if((i - blancPos) < maxLength)
						{
							// insert word wrap after " " at lastBlanc
							i = blancPos;
						}
						else
						{
							// insert hard break at lastPos - no blanc in last
							// maxLength chars
							i = lastPos;
						}
						inserted = true;
						result = result.substring(0, i) + delimiter + result.substring(i);
						i += delimiter.length() - 1; // continue after
														// delimiter
						breakcount++;
					}
				}
			}
		}
		if(opencount == 0)
		{
			return result;
		}
		else
		{
			// some tags not properly closed : no changes
			return line;
		}
	}


	/**
	 * @param piFromTime
	 * @param piToTime
	 * @return
	 */
	public static String getTimeIntervalString(int piFromTime,int piToTime)
	{

		String sRet = "";

		sRet = getTimeString(piFromTime,true)+ " - "+ getTimeString(piToTime,true);

		return sRet;
	}

	/**
	 * @param piTime
	 * @param pbFormated
	 * @return
	 */
	public static String getTimeString(int piTime,boolean pbFormated)
	{
		String sTime = "" +piTime;


		if(sTime.length()==1)
		{
			sTime = "000"+sTime;
		}
		if(sTime.length()==2)
		{
			sTime = "00"+sTime;
		}
		else if(sTime.length()==3)
		{
			sTime = "0"+sTime;
		}

		if(pbFormated)
		{
			sTime = sTime.substring(0,2)+":"+sTime.substring(2);
		}


		return sTime;
	}

	/**
	 * @param piTime
	 * @return
	 */
	public static int getRoundedTime(int piTime )
	{
		int iRet = piTime;
		String sTime = getTimeString(piTime,false);
		int iHour;
		int iMinute;



		if(sTime.length() == 4)
		{
			iHour = toInt(sTime.substring(0,2),0);
			iMinute = toInt(sTime.substring(2),0);

			//5 Minuts Block
			if(iMinute >57)
			{
				if(iHour < 23 )
				{
					iHour++;
				}
				else
				{
					iHour = 0;
				}
			}
			iMinute = (int)Math.round((double)iMinute/5)*5;

			while(iMinute >= 60   )
			{
				iMinute -=  60;
			}

			iRet = iHour*100 + iMinute;


		}





		return iRet;
	}

	/**
	 * 
	 */
	public StringUtils()
	{
		;
	}

	public static int compare(String s1, String s2) {

		int retVal;

		if (s1 == null && s2 == null) {
			retVal = 0;
		} else if (s1 == null && s2 != null) {
			retVal = Integer.MIN_VALUE;
		} else if (s1 != null && s2 == null) {
			retVal = Integer.MAX_VALUE;
		} else {
			retVal = s1.compareTo(s2);
		}
		return retVal;

	}

	public static boolean equals(String s1, String s2) {
		return 0 == compare(s1, s2);
	}

	public static boolean isNotNullEmptyBlank(String s1) {
		return s1 != null && s1.trim().length() > 0;
	}

	public static boolean isNullEmptyBlank(String s1) {
		return s1 == null || s1.trim().length() == 0;
	}

	public static boolean isNotNullEmpty(String s1) {
		return s1 != null && s1.length() > 0;
	}

	public static boolean isNullEmpty(String s1) {
		return s1 == null || s1.length() == 0;
	}

	public static String copy(String s1) {
		if (s1 == null) {
			return "";
		}
		return s1;
	}


	//mix for msi#151
	public static boolean isNumeric( String psStringToProof) {

		int start = 0 ;

		if (psStringToProof == null || psStringToProof.length() < 1) {
			return false;
		}

		for(int i = start; i < psStringToProof.length(); i++) {
			if (!Character.isDigit(psStringToProof.charAt(i))) {
				return false;
			}
		}

		return true;

	}
	
	/**
	 * Mask a CreditCard number with "*" 
	 * <br/>for TUI!!
	 * @param ccNo
	 * @return
	 */
	public static String maskCCNo(String ccNo)
	{
		String maskedNo = ccNo;
		
		if(ccNo.length() >= 12)
		{
			maskedNo = ccNo.substring(0, 6) 
				+ "******" 
				+ ccNo.substring(12, ccNo.length());
		}
		else
		{
			//TODO: ??
		}
		
		return maskedNo;
	}
	/**
	 * Nices up text. All words are made lowercase with uppercase first letter.
	 * Words shorter 4 letters are hold uppercase complete.
	 * Certain kewords are all lowercase
	 * @param text
	 * @return
	 */
	public static String niceText(String text) {
		// s.a. <Utils>com.bpcs.basic.utils.StringUtils#niceText
		return niceText(text, new LinkedList());	
	}
	/**
	 * Nices up text. All words are made lowercase with uppercase first letter.
	 * Words shorter 4 letters are hold uppercase complete.
	 * Certain kewords are all lowercase
	 * @param text
	 * @param removeWords 
	 * @return
	 */	
	public static String niceText(String text, List removeWords)
	{
		List  lowercaseWords = Arrays.asList(
				new String[]{
						"similar", 
				"or"});
		String ret = text.toLowerCase();
		//remove things like "Group A -" from front 
		if(ret.startsWith("group"))
		{
			String[] parts = ret.split("-");
			if(parts.length >= 1)
			{
				ret = "";
				for(int i=1; i< parts.length ;i ++)
				{
					if(i>1)
						ret += " ";//separator
					ret += parts[i].trim();
				}
			}
		}
		String[] words = ret.split(" ");
		ret = new String();
		for(int i=0; i< words.length ;i ++)
		{
			char[] word = words[i].toCharArray();
			if(removeWords.contains(words[i]))
			{
				//don't append words that should be removed
				continue;
			}
			if(word.length > 3 && !words[i].equals("similar"))
			{
				word[0] = Character.toUpperCase(word[0]);
				ret += new String(word) + " ";
			}
			//else if(!words[i].equals("or")&& !words[i].equals("similar"))
			else if(!lowercaseWords.contains(words[i]))
			{
				ret += words[i].toUpperCase() + " ";
			}
			else
				ret += words[i] + " ";

		}
		ret = ret.trim();

		return ret;
	}	
	
	/**
	 * ersetzt Tag-Inhalte durch ***** für eine anonymisierte Darstellung der
	 * Inhalte im Logfile
	 * @param origXML
	 * @param replaceTags Liste der zu anonymisierenden Tags
	 * @return
	 */
	public static String logAnonymXML(String origXML, List replaceTags)
	{
		if(null == replaceTags || replaceTags.isEmpty())
		{
			return origXML;
		}
		String replaced = origXML;
		
		Iterator tagsIt = replaceTags.iterator();
		while(tagsIt.hasNext())
		{
			String tag = (String)tagsIt.next();
			
			String regex = "<" + tag + ">.*</"+ tag + ">";
			String replacement = "<" + tag + ">***********</"+ tag + ">";
			replaced = replaced.replaceAll(regex, replacement);
		}
		return replaced;
	}

	public static String cutToLengthOrEmpty(String orig, int length)
	{
		String cut = orig;
		if(null == orig)
		{
			return "";
		}
		if(orig.length() > length)
		{
			cut = orig.substring(0, length);
		}
		
		return cut;
	}

	/**
	 * tries to extract the port number out of an URL
	 * port number schould be located after a ":" and
	 * before "/" if there is an additional path
	 * @param url
	 * @return
	 */
	public static String getPortFromUrl(String url)
	{
		String port = "";
		
		if(!"".equals(trimNull(url)))
		{
			int portBegin = url.indexOf(":");
			if(portBegin > 0)
			{
				String temp = url.substring(portBegin + 1);
				int portEnd = temp.indexOf("/");
				if(portBegin > 0)
				{
					temp = temp.substring(0, portEnd);
				}
				port = temp;
			}
		}
		
		return port;
	}
	
	public static Set splitToSet(String completeString, String delimeter)
	{
		Set resultList = new HashSet();
		
		if(!"".equals(trimNull(completeString)))
		{
			String[] stringsArray = completeString.split(delimeter);
			if(stringsArray.length > 0)
			{
				for(int i = 0; i<stringsArray.length; i++)
				{
					resultList.add(stringsArray[i]);
				}
			}
		}
		
		return resultList;
	}
	
	public static String quoteSQLString(String text)
	{
		if(null!=text)
		{
			text = "'" + text + "'";
		}
		
		return text;
	}

	public static String generateSeparatedList(String[]valueArray, String separator) {
		StringBuffer separatedString = new StringBuffer();
		for (int i=0; i<valueArray.length; i++) {
			String s = valueArray[i];
			if(isNullEmptyBlank(s))
				continue;
			separatedString.append(s);
			if(i+1 < valueArray.length)
				separatedString.append(separator);
		}

		return separatedString.toString();
	}
}
