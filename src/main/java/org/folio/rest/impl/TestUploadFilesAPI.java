package org.folio.rest.impl;


import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import java.io.InputStream;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.folio.rest.jaxrs.resource.TestUpload;

public class TestUploadFilesAPI implements TestUpload {

  @Override
  public void getTestUploadById(String id, Map<String, String> okapiHeaders,
      Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {

  }

  @Override
  public void postTestUploadById(String id, InputStream entity, Map<String, String> okapiHeaders,
      Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {
    System.out.println("WILL GET HERE: POST!");
    asyncResultHandler.handle(
        Future.succeededFuture(
            PostTestUploadByIdResponse.respond200()));
  }

  @Override
  public void putTestUploadById(String id, InputStream entity, Map<String, String> okapiHeaders,
      Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {
    System.out.println("WILL NEVER GET HERE: PUT!");
    asyncResultHandler.handle(
        Future.succeededFuture(
            PutTestUploadByIdResponse.respond204()));
  }

  @Override
  public void deleteTestUploadById(String id, Map<String, String> okapiHeaders,
      Handler<AsyncResult<Response>> asyncResultHandler, Context vertxContext) {

  }
}
