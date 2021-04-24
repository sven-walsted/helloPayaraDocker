package org.walsted.hello.fish.boundary;

import java.net.URI;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;

import org.walsted.hello.fish.control.FishService;
import org.walsted.hello.fish.entity.Fish;

@Path("fish")
public class FishResource {

	@EJB
	private FishService service;

	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@GET
	public JsonArray find() {
		return newJsonArray(service.findAll());
	}

	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@GET
	@Path("/{id}")
	public JsonObject findById(@PathParam("id") long id) {
		return buildJsonObject(service.find(id));
	}

	@POST
	public Response create(@Valid Fish fish) {
		service.create(fish);
		URI newEntityUri = UriBuilder.fromResource(FishResource.class).path(fish.getId().toString()).build();
		return Response.created(newEntityUri).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id") long id, Fish entity) {
		// Set ID, since you don't know how many properties are present.
		entity.setId(id);
		service.update(entity);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	// @RolesAllowed("a")
	public Response deleteById(@PathParam("id") long id) {
		try {
			service.delete(id);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			System.err.println("Delete: " + e.getMessage());
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	///////////////////////////////////////////////////////////////////////////
	//

	private JsonArray newJsonArray(List<Fish> list) {
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		for (Fish entity : list) {
			try {
				arrayBuilder.add(buildJsonObject(entity));
			} catch (RuntimeException e) {
				System.err.println("Could not build JsonObject for: " + entity);
			}
		}
		return arrayBuilder.build();
	}

	private JsonObject buildJsonObject(Fish fish) {
		JsonObjectBuilder builder = Json.createObjectBuilder().add("id", fish.getId())
				.add("className", fish.getClassName()).add("orderName", fish.getOrderName())
				.add("familyName", fish.getFamilyName()).add("genusName", fish.getGenusName())
				.add("speciesName", fish.getSpeciesName()).add("commonName", fish.getCommonName());

		return builder.build();
	}

}
