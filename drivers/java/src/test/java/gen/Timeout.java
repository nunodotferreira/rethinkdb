// Autogenerated by convert_tests.py and process_polyglot.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../templates/Test.java
package gen;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.exc.*;
import com.rethinkdb.gen.ast.*;
import com.rethinkdb.ast.ReqlAst;
import com.rethinkdb.model.MapObject;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.Instant;
import java.util.stream.LongStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import java.util.Collections;
import java.nio.charset.StandardCharsets;

import static gen.TestingCommon.*;
import gen.TestingFramework;

public class Timeout {
    // Tests timeouts.
    Logger logger = LoggerFactory.getLogger(Timeout.class);
    public static final RethinkDB r = RethinkDB.r;

    Connection<?> conn;
    public String hostname = TestingFramework.getConfig().getHostName();
    public int port = TestingFramework.getConfig().getPort();

    @Before
    public void setUp() throws Exception {
        logger.info("Setting up.");
        conn = TestingFramework.createConnection();
        try {
            r.dbCreate("test").run(conn);
            r.db("test").wait_().run(conn);
        }catch (Exception e){}
    }

    @After
    public void tearDown() throws Exception {
        logger.info("Tearing down.");
        r.db("rethinkdb").table("_debug_scratch").delete().run(conn);
        if(!conn.isOpen()){
            conn.close();
            conn = TestingFramework.createConnection();
        }
        r.dbDrop("test").run(conn);
        conn.close(false);
    }

    // Autogenerated tests below

        @Test(timeout=120000)
    public void test() throws Exception {
                
        {
            // timeout.yaml line #5
            /* err("ReqlQueryLogicError", "JavaScript query `while(true) {}` timed out after 5.000 seconds.", [0]) */
            Err expected_ = err("ReqlQueryLogicError", "JavaScript query `while(true) {}` timed out after 5.000 seconds.", r.array(0L));
            /* r.js('while(true) {}') */
            logger.info("About to run line #5: r.js('while(true) {}')");
            Object obtained = runOrCatch(r.js("while(true) {}"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #5");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #5:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // timeout.yaml line #8
            /* err("ReqlQueryLogicError", "JavaScript query `while(true) {}` timed out after 1.300 seconds.", [0]) */
            Err expected_ = err("ReqlQueryLogicError", "JavaScript query `while(true) {}` timed out after 1.300 seconds.", r.array(0L));
            /* r.js('while(true) {}', timeout=1.3) */
            logger.info("About to run line #8: r.js('while(true) {}').optArg('timeout', 1.3)");
            Object obtained = runOrCatch(r.js("while(true) {}").optArg("timeout", 1.3),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #8");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #8:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // timeout.yaml line #13
            /* err("ReqlQueryLogicError", "JavaScript query `while(true) {}` timed out after 8.000 seconds.", [0]) */
            Err expected_ = err("ReqlQueryLogicError", "JavaScript query `while(true) {}` timed out after 8.000 seconds.", r.array(0L));
            /* r.js('while(true) {}', timeout=8) */
            logger.info("About to run line #13: r.js('while(true) {}').optArg('timeout', 8L)");
            Object obtained = runOrCatch(r.js("while(true) {}").optArg("timeout", 8L),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #13");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #13:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // timeout.yaml line #18
            /* err("ReqlQueryLogicError", "JavaScript query `(function(x) { while(true) {} })` timed out after 5.000 seconds.", [0]) */
            Err expected_ = err("ReqlQueryLogicError", "JavaScript query `(function(x) { while(true) {} })` timed out after 5.000 seconds.", r.array(0L));
            /* r.expr('foo').do(r.js('(function(x) { while(true) {} })')) */
            logger.info("About to run line #18: r.expr('foo').do_(r.js('(function(x) { while(true) {} })'))");
            Object obtained = runOrCatch(r.expr("foo").do_(r.js("(function(x) { while(true) {} })")),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #18");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #18:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // timeout.yaml line #21
            /* err("ReqlQueryLogicError", "JavaScript query `(function(x) { while(true) {} })` timed out after 1.300 seconds.", [0]) */
            Err expected_ = err("ReqlQueryLogicError", "JavaScript query `(function(x) { while(true) {} })` timed out after 1.300 seconds.", r.array(0L));
            /* r.expr('foo').do(r.js('(function(x) { while(true) {} })', timeout=1.3)) */
            logger.info("About to run line #21: r.expr('foo').do_(r.js('(function(x) { while(true) {} })').optArg('timeout', 1.3))");
            Object obtained = runOrCatch(r.expr("foo").do_(r.js("(function(x) { while(true) {} })").optArg("timeout", 1.3)),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #21");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #21:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // timeout.yaml line #26
            /* err("ReqlQueryLogicError", "JavaScript query `(function(x) { while(true) {} })` timed out after 8.000 seconds.", [0]) */
            Err expected_ = err("ReqlQueryLogicError", "JavaScript query `(function(x) { while(true) {} })` timed out after 8.000 seconds.", r.array(0L));
            /* r.expr('foo').do(r.js('(function(x) { while(true) {} })', timeout=8)) */
            logger.info("About to run line #26: r.expr('foo').do_(r.js('(function(x) { while(true) {} })').optArg('timeout', 8L))");
            Object obtained = runOrCatch(r.expr("foo").do_(r.js("(function(x) { while(true) {} })").optArg("timeout", 8L)),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #26");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #26:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // timeout.yaml line #32
            /* err("ReqlNonExistenceError", "Error in HTTP GET of `httpbin.org/delay/10`:" + " timed out after 0.800 seconds.", []) */
            Err expected_ = err("ReqlNonExistenceError", "Error in HTTP GET of `httpbin.org/delay/10`:" + " timed out after 0.800 seconds.", r.array());
            /* r.http('httpbin.org/delay/10', timeout=0.8) */
            logger.info("About to run line #32: r.http('httpbin.org/delay/10').optArg('timeout', 0.8)");
            Object obtained = runOrCatch(r.http("httpbin.org/delay/10").optArg("timeout", 0.8),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #32");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #32:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // timeout.yaml line #36
            /* err("ReqlNonExistenceError", "Error in HTTP PUT of `httpbin.org/delay/10`:" + " timed out after 0.000 seconds.", []) */
            Err expected_ = err("ReqlNonExistenceError", "Error in HTTP PUT of `httpbin.org/delay/10`:" + " timed out after 0.000 seconds.", r.array());
            /* r.http('httpbin.org/delay/10', method='PUT', timeout=0.0) */
            logger.info("About to run line #36: r.http('httpbin.org/delay/10').optArg('method', 'PUT').optArg('timeout', 0.0)");
            Object obtained = runOrCatch(r.http("httpbin.org/delay/10").optArg("method", "PUT").optArg("timeout", 0.0),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #36");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #36:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
    }
}
