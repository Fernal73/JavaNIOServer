package com.jenkov.nioserver;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import org.junit.jupiter.api.Test;

/** Created by jjenkov on 21-10-2015. */
public class SelectorTest {

  @Test
  public void test() throws IOException {
    Selector selector = Selector.open();

    SocketChannel socketChannel = SocketChannel.open();
    socketChannel.bind(new InetSocketAddress("localhost", 9999));

    socketChannel.configureBlocking(false);

    SelectionKey key1 = socketChannel.register(selector, SelectionKey.OP_WRITE);
    key1.cancel();

    assertThrows(
        CancelledKeyException.class,
        () -> {
          SelectionKey key2 = socketChannel.register(selector, SelectionKey.OP_WRITE);
          key2.cancel();
        });
  }
}
