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

public class MathLogicMul {
    // Tests for the basic usage of the multiplication operation
    Logger logger = LoggerFactory.getLogger(MathLogicMul.class);
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
            // math_logic/mul.yaml line #6
            /* 2 */
            Long expected_ = 2L;
            /* r.expr(1) * 2 */
            logger.info("About to run line #6: r.expr(1L).mul(2L)");
            Object obtained = runOrCatch(r.expr(1L).mul(2L),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #6");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #6:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // math_logic/mul.yaml line #7
            /* 2 */
            Long expected_ = 2L;
            /* 1 * r.expr(2) */
            logger.info("About to run line #7: r.mul(1L, r.expr(2L))");
            Object obtained = runOrCatch(r.mul(1L, r.expr(2L)),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #7");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #7:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // math_logic/mul.yaml line #8
            /* 2 */
            Long expected_ = 2L;
            /* r.expr(1).mul(2) */
            logger.info("About to run line #8: r.expr(1L).mul(2L)");
            Object obtained = runOrCatch(r.expr(1L).mul(2L),
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
            // math_logic/mul.yaml line #15
            /* 1 */
            Long expected_ = 1L;
            /* r.expr(-1) * -1 */
            logger.info("About to run line #15: r.expr(-1L).mul(-1L)");
            Object obtained = runOrCatch(r.expr(-1L).mul(-1L),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #15");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #15:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // math_logic/mul.yaml line #21
            /* 6.75 */
            Double expected_ = 6.75;
            /* r.expr(1.5) * 4.5 */
            logger.info("About to run line #21: r.expr(1.5).mul(4.5)");
            Object obtained = runOrCatch(r.expr(1.5).mul(4.5),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals((double) expected_,
                             ((Number) obtained).doubleValue(),
                             0.00000000001);
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
            // math_logic/mul.yaml line #25
            /* [1,2,3,1,2,3,1,2,3] */
            List expected_ = r.array(1L, 2L, 3L, 1L, 2L, 3L, 1L, 2L, 3L);
            /* r.expr([1,2,3]) * 3 */
            logger.info("About to run line #25: r.expr(r.array(1L, 2L, 3L)).mul(3L)");
            Object obtained = runOrCatch(r.expr(r.array(1L, 2L, 3L)).mul(3L),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #25");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #25:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // math_logic/mul.yaml line #30
            /* 120 */
            Long expected_ = 120L;
            /* r.expr(1).mul(2,3,4,5) */
            logger.info("About to run line #30: r.expr(1L).mul(2L, 3L, 4L, 5L)");
            Object obtained = runOrCatch(r.expr(1L).mul(2L, 3L, 4L, 5L),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #30");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #30:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // math_logic/mul.yaml line #46
            /* err('ReqlQueryLogicError', 'Expected type NUMBER but found STRING.', [0]) */
            Err expected_ = err("ReqlQueryLogicError", "Expected type NUMBER but found STRING.", r.array(0L));
            /* r.expr('a') * 0.8 */
            logger.info("About to run line #46: r.expr('a').mul(0.8)");
            Object obtained = runOrCatch(r.expr("a").mul(0.8),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #46");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #46:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // math_logic/mul.yaml line #50
            /* err('ReqlQueryLogicError', 'Expected type NUMBER but found STRING.', [1]) */
            Err expected_ = err("ReqlQueryLogicError", "Expected type NUMBER but found STRING.", r.array(1L));
            /* r.expr(1) * 'a' */
            logger.info("About to run line #50: r.expr(1L).mul('a')");
            Object obtained = runOrCatch(r.expr(1L).mul("a"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #50");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #50:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // math_logic/mul.yaml line #54
            /* err('ReqlQueryLogicError', 'Expected type NUMBER but found STRING.', [0]) */
            Err expected_ = err("ReqlQueryLogicError", "Expected type NUMBER but found STRING.", r.array(0L));
            /* r.expr('b') * 'a' */
            logger.info("About to run line #54: r.expr('b').mul('a')");
            Object obtained = runOrCatch(r.expr("b").mul("a"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #54");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #54:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // math_logic/mul.yaml line #58
            /* err('ReqlQueryLogicError', 'Number not an integer: 1.5', [0]) */
            Err expected_ = err("ReqlQueryLogicError", "Number not an integer: 1.5", r.array(0L));
            /* r.expr([]) * 1.5 */
            logger.info("About to run line #58: r.expr(r.array()).mul(1.5)");
            Object obtained = runOrCatch(r.expr(r.array()).mul(1.5),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #58");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #58:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
    }
}
