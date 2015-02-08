package com.bpcs.sunny.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.bpcs.suny.tool.tdva.NoContentException;
import com.bpcs.suny.tool.tdva.TDVAListener;
import com.bpcs.suny.tool.tdva.TDVAProxyManager;
import com.bpcs.suny.tool.tdva.TdvaSettings;
import com.bpcs.suny.tool.tdva.TimeoutException;

@Singleton
public class TdvaService {

	private static final Logger LOG = Logger.getLogger(TdvaService.class);

	@Inject
	private ConfigService configService;

	@PostConstruct
	private void init() {

		TdvaSettings settings = new TdvaSettings();
		String path = configService.getTdvaPath();
		// settings.setConnectPort(configService.getTdvaPath());
		// settings.setPackageDelimiter(AbstractRequestor.getTdvaPackageDelimiter());
		// settings.setProvider(AbstractRequestor.getTdvaProvider());
		// settings.setTimeout(AbstractRequestor.getTdvaTimeOut());

		TDVAListener tdvaListener = new TDVAListener(settings);
		Thread t1 = new Thread(tdvaListener);
		t1.setDaemon(true);
		t1.start();

	}

	public void start() {

	}

	public String sendTDVARequest(String requestString, String sessionId) {
		long startTime = System.currentTimeMillis();

		String response = null;
		try {
			LOG.info("initiate call to TDVA: " + requestString);
			response = TDVAProxyManager.tdvaRequest(requestString);
		} catch (NoContentException e) {
			LOG.error("received no content during call to TDVA: ", e);
			response = TDVAProxyManager.timeoutResponse;
		} catch (TimeoutException e) {
			LOG.error("received TimeoutException during call to TDVA: ", e);
			response = TDVAProxyManager.timeoutResponse;
		} finally {
			LOG.info("call to tdva lasted "
					+ Long.toString(System.currentTimeMillis() - startTime)
					+ " ms, result: " + response);
		}
		return response;

	}

}
