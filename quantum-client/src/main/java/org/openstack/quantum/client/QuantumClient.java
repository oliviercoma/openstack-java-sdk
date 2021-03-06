package org.openstack.quantum.client;

import javax.ws.rs.client.WebTarget;

import org.openstack.OpenStack;
import org.openstack.common.client.AbstractOpenStackClient;

public class QuantumClient extends AbstractOpenStackClient {
	public QuantumClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

	public <R> R execute(QuantumCommand<R> command) {
		WebTarget endpoint = OpenStack.CLIENT.target(endpointURL);
		if(token != null) {
			endpoint.register(tokenFilter);
		}
		return command.execute(endpoint);
	}

}
