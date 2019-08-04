/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.net.ServerSocketFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adam
 */
public class HTTPServerIT {
    
    public HTTPServerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPort method, of class HTTPServer.
     */
    @Test
    public void testSetPort() {
        System.out.println("setPort");
        int port = 0;
        HTTPServer instance = new HTTPServer();
        instance.setPort(port);

    }

    /**
     * Test of setServerSocketFactory method, of class HTTPServer.
     */
    @Test
    public void testSetServerSocketFactory() {
        System.out.println("setServerSocketFactory");
        ServerSocketFactory factory = null;
        HTTPServer instance = new HTTPServer();
        instance.setServerSocketFactory(factory);

    }

    /**
     * Test of setSocketTimeout method, of class HTTPServer.
     */
    @Test
    public void testSetSocketTimeout() {
        System.out.println("setSocketTimeout");
        int timeout = 0;
        HTTPServer instance = new HTTPServer();
        instance.setSocketTimeout(timeout);

    }

    /**
     * Test of setExecutor method, of class HTTPServer.
     */
    @Test
    public void testSetExecutor() {
        System.out.println("setExecutor");
        Executor executor = null;
        HTTPServer instance = new HTTPServer();
        instance.setExecutor(executor);

    }

    /**
     * Test of getVirtualHost method, of class HTTPServer.
     */
    @Test
    public void testGetVirtualHost() {
        System.out.println("getVirtualHost");
        String name = "";
        HTTPServer instance = new HTTPServer();
        HTTPServer.VirtualHost expResult = null;
        HTTPServer.VirtualHost result = instance.getVirtualHost(name);
        assertEquals(expResult, result);

    }

    /**
     * Test of getVirtualHosts method, of class HTTPServer.
     */
    @Test
    public void testGetVirtualHosts() {
        System.out.println("getVirtualHosts");
        HTTPServer instance = new HTTPServer();
        Set<HTTPServer.VirtualHost> expResult = null;
        Set<HTTPServer.VirtualHost> result = instance.getVirtualHosts();
        assertEquals(expResult, result);

    }

    /**
     * Test of addVirtualHost method, of class HTTPServer.
     */
    @Test
    public void testAddVirtualHost() {
        System.out.println("addVirtualHost");
        HTTPServer.VirtualHost host = null;
        HTTPServer instance = new HTTPServer();
        instance.addVirtualHost(host);

    }

    /**
     * Test of createServerSocket method, of class HTTPServer.
     */
    @Test
    public void testCreateServerSocket() throws Exception {
        System.out.println("createServerSocket");
        HTTPServer instance = new HTTPServer();
        ServerSocket expResult = null;
        ServerSocket result = instance.createServerSocket();
        assertEquals(expResult, result);

    }

    /**
     * Test of start method, of class HTTPServer.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        HTTPServer instance = new HTTPServer();
        instance.start();

    }

    /**
     * Test of stop method, of class HTTPServer.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        HTTPServer instance = new HTTPServer();
        instance.stop();

    }

    /**
     * Test of handleConnection method, of class HTTPServer.
     */
    @Test
    public void testHandleConnection() throws Exception {
        System.out.println("handleConnection");
        InputStream in = null;
        OutputStream out = null;
        HTTPServer instance = new HTTPServer();
        instance.handleConnection(in, out);

    }

    /**
     * Test of handleTransaction method, of class HTTPServer.
     */
    @Test
    public void testHandleTransaction() throws Exception {
        System.out.println("handleTransaction");
        HTTPServer.Request req = null;
        HTTPServer.Response resp = null;
        HTTPServer instance = new HTTPServer();
        instance.handleTransaction(req, resp);

    }

    /**
     * Test of preprocessTransaction method, of class HTTPServer.
     */
    @Test
    public void testPreprocessTransaction() throws Exception {
        System.out.println("preprocessTransaction");
        HTTPServer.Request req = null;
        HTTPServer.Response resp = null;
        HTTPServer instance = new HTTPServer();
        boolean expResult = false;
        boolean result = instance.preprocessTransaction(req, resp);
        assertEquals(expResult, result);

    }

    /**
     * Test of handleMethod method, of class HTTPServer.
     */
    @Test
    public void testHandleMethod() throws Exception {
        System.out.println("handleMethod");
        HTTPServer.Request req = null;
        HTTPServer.Response resp = null;
        HTTPServer instance = new HTTPServer();
        instance.handleMethod(req, resp);

    }

    /**
     * Test of handleTrace method, of class HTTPServer.
     */
    @Test
    public void testHandleTrace() throws Exception {
        System.out.println("handleTrace");
        HTTPServer.Request req = null;
        HTTPServer.Response resp = null;
        HTTPServer instance = new HTTPServer();
        instance.handleTrace(req, resp);

    }

    /**
     * Test of serve method, of class HTTPServer.
     */
    @Test
    public void testServe() throws Exception {
        System.out.println("serve");
        HTTPServer.Request req = null;
        HTTPServer.Response resp = null;
        HTTPServer instance = new HTTPServer();
        instance.serve(req, resp);

    }

    /**
     * Test of addContentType method, of class HTTPServer.
     */
    @Test
    public void testAddContentType() {
        System.out.println("addContentType");
        String contentType = "";
        String[] suffixes = null;
        HTTPServer.addContentType(contentType, suffixes);

    }

    /**
     * Test of addContentTypes method, of class HTTPServer.
     */
    @Test
    public void testAddContentTypes() throws Exception {
        System.out.println("addContentTypes");
        File mimeTypes = null;
        HTTPServer.addContentTypes(mimeTypes);

    }

    /**
     * Test of getContentType method, of class HTTPServer.
     */
    @Test
    public void testGetContentType() {
        System.out.println("getContentType");
        String path = "";
        String def = "";
        String expResult = "";
        String result = HTTPServer.getContentType(path, def);
        assertEquals(expResult, result);

    }

    /**
     * Test of isCompressible method, of class HTTPServer.
     */
    @Test
    public void testIsCompressible() {
        System.out.println("isCompressible");
        String contentType = "";
        boolean expResult = false;
        boolean result = HTTPServer.isCompressible(contentType);
        assertEquals(expResult, result);

    }

    /**
     * Test of detectLocalHostName method, of class HTTPServer.
     */
    @Test
    public void testDetectLocalHostName() {
        System.out.println("detectLocalHostName");
        String expResult = "";
        String result = HTTPServer.detectLocalHostName();
        assertEquals(expResult, result);

    }

    /**
     * Test of parseParamsList method, of class HTTPServer.
     */
    @Test
    public void testParseParamsList() {
        System.out.println("parseParamsList");
        String s = "";
        List expResult = null;
        List result = HTTPServer.parseParamsList(s);
        assertEquals(expResult, result);

    }

    /**
     * Test of toMap method, of class HTTPServer.
     */
    @Test
    public void testToMap() {
        System.out.println("toMap");
        Collection pairs = null;
        Map expResult = null;
        Map result = HTTPServer.toMap(pairs);
        assertEquals(expResult, result);

    }

    /**
     * Test of parseRange method, of class HTTPServer.
     */
    @Test
    public void testParseRange() {
        System.out.println("parseRange");
        String range = "";
        long length = 0L;
        long[] expResult = null;
        long[] result = HTTPServer.parseRange(range, length);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of parseULong method, of class HTTPServer.
     */
    @Test
    public void testParseULong() {
        System.out.println("parseULong");
        String s = "";
        int radix = 0;
        long expResult = 0L;
        long result = HTTPServer.parseULong(s, radix);
        assertEquals(expResult, result);

    }

    /**
     * Test of parseDate method, of class HTTPServer.
     */
    @Test
    public void testParseDate() {
        System.out.println("parseDate");
        String time = "";
        Date expResult = null;
        Date result = HTTPServer.parseDate(time);
        assertEquals(expResult, result);

    }

    /**
     * Test of formatDate method, of class HTTPServer.
     */
    @Test
    public void testFormatDate() {
        System.out.println("formatDate");
        long time = 0L;
        String expResult = "";
        String result = HTTPServer.formatDate(time);
        assertEquals(expResult, result);

    }

    /**
     * Test of splitElements method, of class HTTPServer.
     */
    @Test
    public void testSplitElements() {
        System.out.println("splitElements");
        String list = "";
        boolean lower = false;
        String[] expResult = null;
        String[] result = HTTPServer.splitElements(list, lower);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of split method, of class HTTPServer.
     */
    @Test
    public void testSplit() {
        System.out.println("split");
        String str = "";
        String delimiters = "";
        int limit = 0;
        String[] expResult = null;
        String[] result = HTTPServer.split(str, delimiters, limit);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of join method, of class HTTPServer.
     */
    @Test
    public void testJoin() {
        System.out.println("join");
        String expResult = "";
        String result = "";
        assertEquals(expResult, result);
    }

    /**
     * Test of getParentPath method, of class HTTPServer.
     */
    @Test
    public void testGetParentPath() {
        System.out.println("getParentPath");
        String path = "";
        String expResult = "";
        String result = HTTPServer.getParentPath(path);
        assertEquals(expResult, result);
    }

    /**
     * Test of trimRight method, of class HTTPServer.
     */
    @Test
    public void testTrimRight() {
        System.out.println("trimRight");
        String s = "";
        char c = ' ';
        String expResult = "";
        String result = HTTPServer.trimRight(s, c);
        assertEquals(expResult, result);
    }

    /**
     * Test of trimLeft method, of class HTTPServer.
     */
    @Test
    public void testTrimLeft() {
        System.out.println("trimLeft");
        String s = "";
        char c = ' ';
        String expResult = "";
        String result = HTTPServer.trimLeft(s, c);
        assertEquals(expResult, result);
    }

    /**
     * Test of trimDuplicates method, of class HTTPServer.
     */
    @Test
    public void testTrimDuplicates() {
        System.out.println("trimDuplicates");
        String s = "";
        char c = ' ';
        String expResult = "";
        String result = HTTPServer.trimDuplicates(s, c);
        assertEquals(expResult, result);
    }

    /**
     * Test of toSizeApproxString method, of class HTTPServer.
     */
    @Test
    public void testToSizeApproxString() {
        System.out.println("toSizeApproxString");
        long size = 0L;
        String expResult = "";
        String result = HTTPServer.toSizeApproxString(size);
        assertEquals(expResult, result);
    }

    /**
     * Test of escapeHTML method, of class HTTPServer.
     */
    @Test
    public void testEscapeHTML() {
        System.out.println("escapeHTML");
        String s = "";
        String expResult = "";
        String result = HTTPServer.escapeHTML(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBytes method, of class HTTPServer.
     */
    @Test
    public void testGetBytes() {
        System.out.println("getBytes");
        String[] strings = null;
        byte[] expResult = null;
        byte[] result = HTTPServer.getBytes(strings);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of transfer method, of class HTTPServer.
     */
    @Test
    public void testTransfer() throws Exception {
        System.out.println("transfer");
        InputStream in = null;
        OutputStream out = null;
        long len = 0L;
        HTTPServer.transfer(in, out, len);
    }

    /**
     * Test of readToken method, of class HTTPServer.
     */
    @Test
    public void testReadToken() throws Exception {
        System.out.println("readToken");
        InputStream in = null;
        int delim = 0;
        String enc = "";
        int maxLength = 0;
        String expResult = "";
        String result = HTTPServer.readToken(in, delim, enc, maxLength);
        assertEquals(expResult, result);
    }

    /**
     * Test of readLine method, of class HTTPServer.
     */
    @Test
    public void testReadLine() throws Exception {
        System.out.println("readLine");
        InputStream in = null;
        String expResult = "";
        String result = HTTPServer.readLine(in);
        assertEquals(expResult, result);

    }

    /**
     * Test of readHeaders method, of class HTTPServer.
     */
    @Test
    public void testReadHeaders() throws Exception {
        System.out.println("readHeaders");
        InputStream in = null;
        HTTPServer.Headers expResult = null;
        HTTPServer.Headers result = HTTPServer.readHeaders(in);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of match method, of class HTTPServer.
     */
    @Test
    public void testMatch() {
        System.out.println("match");
        boolean strong = false;
        String[] etags = null;
        String etag = "";
        boolean expResult = false;
        boolean result = HTTPServer.match(strong, etags, etag);
        assertEquals(expResult, result);

    }

    /**
     * Test of getConditionalStatus method, of class HTTPServer.
     */
    @Test
    public void testGetConditionalStatus() {
        System.out.println("getConditionalStatus");
        HTTPServer.Request req = null;
        long lastModified = 0L;
        String etag = "";
        int expResult = 0;
        int result = HTTPServer.getConditionalStatus(req, lastModified, etag);
        assertEquals(expResult, result);
    }

    /**
     * Test of serveFile method, of class HTTPServer.
     */
    @Test
    public void testServeFile() throws Exception {
        System.out.println("serveFile");
        File base = null;
        String context = "";
        HTTPServer.Request req = null;
        HTTPServer.Response resp = null;
        int expResult = 0;
        int result = HTTPServer.serveFile(base, context, req, resp);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of serveFileContent method, of class HTTPServer.
     */
    @Test
    public void testServeFileContent() throws Exception {
        System.out.println("serveFileContent");
        File file = null;
        HTTPServer.Request req = null;
        HTTPServer.Response resp = null;
        HTTPServer.serveFileContent(file, req, resp);
       
    }

    /**
     * Test of createIndex method, of class HTTPServer.
     */
    @Test
    public void testCreateIndex() {
        System.out.println("createIndex");
        File dir = null;
        String path = "";
        String expResult = "";
        String result = HTTPServer.createIndex(dir, path);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of main method, of class HTTPServer.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        HTTPServer.main(args);
   
    }
    
}
