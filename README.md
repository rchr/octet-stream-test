# Test File Upload

Module to document file upload (POST/PUT)

Interfaces are generated via Raml Module Builder

Implementations are just stubs

## POST

Works as expected. Returns HTTP 200.

Request was send via curl:
```bash
curl --request POST \              
  --url http://localhost:8081/test-upload/943bc4f5-2884-4f3f-b6b6-d69e5679ed8d \
  --header 'content-type: application/octet-stream' \
  --header 'x-okapi-tenant: diku' \
  --data Foobar
```

## PUT

Works not as expected. Returns HTTP 400 with the following message:
`Unable to process requestRequest has already been read`

Never reaches the method body: `System.out.println("WILL NEVER GET HERE: PUT!");`

Request was send via curl:
```bash
curl --request PUT \
  --url http://localhost:8081/test-upload/943bc4f5-2884-4f3f-b6b6-d69e5679ed8d \
  --header 'content-type: application/octet-stream' \
  --header 'x-okapi-tenant: diku' \
  --data Foobar
```

The following exception is logged:
```
09 Jul 2019 11:43:44:056 ERROR RestVerticle [6284eqId] Request has already been read
java.lang.IllegalStateException: Request has already been read
	at io.vertx.core.http.impl.HttpServerRequestImpl.checkEnded(HttpServerRequestImpl.java:438) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.http.impl.HttpServerRequestImpl.handler(HttpServerRequestImpl.java:203) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.ext.web.impl.HttpServerRequestWrapper.handler(HttpServerRequestWrapper.java:39) ~[vertx-web-3.5.4.jar:3.5.4]
	at org.folio.rest.RestVerticle.handleInputStreamUpload(RestVerticle.java:632) ~[domain-models-runtime-26.1.0.jar:?]
	at org.folio.rest.RestVerticle.route(RestVerticle.java:522) ~[domain-models-runtime-26.1.0.jar:?]
	at org.folio.rest.RestVerticle.lambda$11(RestVerticle.java:288) ~[domain-models-runtime-26.1.0.jar:?]
	at io.vertx.ext.web.impl.RouteImpl.handleContext(RouteImpl.java:225) ~[vertx-web-3.5.4.jar:3.5.4]
	at io.vertx.ext.web.impl.RoutingContextImplBase.iterateNext(RoutingContextImplBase.java:120) ~[vertx-web-3.5.4.jar:3.5.4]
	at io.vertx.ext.web.impl.RoutingContextImpl.next(RoutingContextImpl.java:133) ~[vertx-web-3.5.4.jar:3.5.4]
	at io.vertx.ext.web.handler.impl.BodyHandlerImpl$BHandler.doEnd(BodyHandlerImpl.java:231) ~[vertx-web-3.5.4.jar:3.5.4]
	at io.vertx.ext.web.handler.impl.BodyHandlerImpl$BHandler.end(BodyHandlerImpl.java:211) ~[vertx-web-3.5.4.jar:3.5.4]
	at io.vertx.ext.web.handler.impl.BodyHandlerImpl.lambda$handle$0(BodyHandlerImpl.java:74) ~[vertx-web-3.5.4.jar:3.5.4]
	at io.vertx.core.http.impl.HttpServerRequestImpl.handleEnd(HttpServerRequestImpl.java:417) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.http.impl.Http1xServerConnection.handleEnd(Http1xServerConnection.java:482) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.http.impl.Http1xServerConnection.handleContent(Http1xServerConnection.java:477) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.http.impl.Http1xServerConnection.processMessage(Http1xServerConnection.java:458) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.http.impl.Http1xServerConnection.handleMessage(Http1xServerConnection.java:144) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.http.impl.HttpServerImpl$ServerHandlerWithWebSockets.handleMessage(HttpServerImpl.java:728) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.http.impl.HttpServerImpl$ServerHandlerWithWebSockets.handleMessage(HttpServerImpl.java:619) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.net.impl.VertxHandler.lambda$channelRead$1(VertxHandler.java:146) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.impl.ContextImpl.lambda$wrapTask$2(ContextImpl.java:337) ~[vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.impl.ContextImpl.executeFromIO(ContextImpl.java:195) [vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.net.impl.VertxHandler.channelRead(VertxHandler.java:144) [vertx-core-3.5.4.jar:3.5.4]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.ChannelInboundHandlerAdapter.channelRead(ChannelInboundHandlerAdapter.java:86) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.handler.codec.MessageToMessageDecoder.channelRead(MessageToMessageDecoder.java:102) [netty-codec-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.handler.codec.MessageToMessageCodec.channelRead(MessageToMessageCodec.java:111) [netty-codec-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:310) [netty-codec-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:284) [netty-codec-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.vertx.core.http.impl.Http1xOrH2CHandler.end(Http1xOrH2CHandler.java:61) [vertx-core-3.5.4.jar:3.5.4]
	at io.vertx.core.http.impl.Http1xOrH2CHandler.channelRead(Http1xOrH2CHandler.java:38) [vertx-core-3.5.4.jar:3.5.4]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1359) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:935) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:141) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:645) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:580) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:497) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:459) [netty-transport-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:886) [netty-common-4.1.19.Final.jar:4.1.19.Final]
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30) [netty-common-4.1.19.Final.jar:4.1.19.Final]
	at java.lang.Thread.run(Thread.java:748) [?:1.8.0_212]
09 Jul 2019 11:43:44:062 INFO  LogUtil [6290eqId] 127.0.0.1:43820 PUT /test-upload/943bc4f5-2884-4f3f-b6b6-d69e5679ed8d null HTTP_1_1 400 54 -1 tid=null Bad Request Unable to process requestRequest has already been read
```

