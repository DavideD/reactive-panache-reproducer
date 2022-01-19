package org.acme.hibernate.orm.panache;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

@Path("/payload")
public class ReceivedDataPayloadResource {

	@GET
	@Path("/reactive/{rd_id}")
	public Uni<ReceivedDataPayload> getReactivePart(@PathParam("rd_id") Long rdId) {
		return ReceivedDataPayload.<ReceivedDataPayload>find( "rdId", rdId )
				.firstResult();
	}

	@GET
	@Path("/blocking/{rd_id}")
	@Blocking
	public ReceivedDataPayload getBlockingPart(@PathParam("rd_id") Long rdId) {
		return ReceivedDataPayload.<ReceivedDataPayload>find( "rdId", rdId )
				.firstResult().await().indefinitely();
	}
}
