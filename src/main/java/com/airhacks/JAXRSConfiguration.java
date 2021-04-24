package com.airhacks;

import javax.annotation.security.DeclareRoles;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 * 
 * Uses realm (good for development and unit testing) defined by:
 * TestIdentityStore. Alternatively, you can use the file realm, etc. in Payara.
 *
 * @author airhacks.com
 */
@ApplicationPath("resources")
@DeclareRoles({ "a", "b" })
@BasicAuthenticationMechanismDefinition(realmName = "file2")
public class JAXRSConfiguration extends Application {

}
