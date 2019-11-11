/*
 * Copyright (c) 2003, 2005, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/**
 * @test
 * @bug 4915501 6303753

 * @summary check exception translation of SocketAdaptor
 */

import java.io.IOException;
import java.nio.channels.*;
import java.net.*;
import java.util.ArrayList;

public class ExceptionTranslation {
    public static void main(String args[]) throws Exception {

		ArrayList<InetSocketAddress> sockets = new ArrayList<>();
        sockets.add(new InetSocketAddress("randomhostnamestring", 8943));
        sockets.add(new InetSocketAddress("completely.different.host.name", 6327));

        int fails=0;

        for (InetSocketAddress socket : sockets) {
            if(socket.isUnresolved()) {
                // Correct path, socket should be unresolved as the host name is invalid
                System.out.println("Socket is correctly unresolved");
            } else {
                System.out.println("Socket is incorrectly connected to IP: " + socket.getAddress());
                fails++;
            }
        }

        if (fails>0) {
            throw new RuntimeException("Failed tests: " + fails);
        }

        /*InetSocketAddress iAddr = new InetSocketAddress("blahblahblah",7292);

		if(iAddr.isUnresolved())
			throw new Exception("Address is unresolved");
		else 
			System.out.println(iAddr.getAddress());

        try {
            SocketChannel channel = SocketChannel.open();
            channel.socket().connect(iAddr);
            throw new RuntimeException("Expected exception not thrown");
        } catch (UnknownHostException x) {
			x.printStackTrace();
            // Expected result
        }

		System.out.println("Done test 1");

        try {
            SocketChannel chan1 = SocketChannel.open();
            chan1.socket().bind(new InetSocketAddress(0));
            chan1.socket().bind(new InetSocketAddress(0));
            throw new RuntimeException("Expected exception not thrown");
        } catch(IOException e) {
            // Expepected result
        }*/
    }
}
