module com.jenkov.nioserver {
  requires java.logging;
  requires java.compiler;
  requires java.management;
  requires org.junit.jupiter.api;
  requires org.junit.jupiter.engine;
  requires org.junit.jupiter.params;
  requires org.junit.platform.commons;
  requires org.junit.platform.engine;
  requires org.junit.platform.launcher;

  exports com.jenkov.nioserver;
  exports com.jenkov.nioserver.http;
}
