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

public class GeoGeojson {
    // Test geoJSON conversion
    Logger logger = LoggerFactory.getLogger(GeoGeojson.class);
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
            // geo/geojson.yaml line #4
            /* ({'$reql_type$':'GEOMETRY', 'coordinates':[0, 0], 'type':'Point'}) */
            Map expected_ = r.hashMap("$reql_type$", "GEOMETRY").with("coordinates", r.array(0L, 0L)).with("type", "Point");
            /* r.geojson({'coordinates':[0, 0], 'type':'Point'}) */
            logger.info("About to run line #4: r.geojson(r.hashMap('coordinates', r.array(0L, 0L)).with('type', 'Point'))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("coordinates", r.array(0L, 0L)).with("type", "Point")),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #4");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #4:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // geo/geojson.yaml line #6
            /* ({'$reql_type$':'GEOMETRY', 'coordinates':[[0,0], [0,1]], 'type':'LineString'}) */
            Map expected_ = r.hashMap("$reql_type$", "GEOMETRY").with("coordinates", r.array(r.array(0L, 0L), r.array(0L, 1L))).with("type", "LineString");
            /* r.geojson({'coordinates':[[0,0], [0,1]], 'type':'LineString'}) */
            logger.info("About to run line #6: r.geojson(r.hashMap('coordinates', r.array(r.array(0L, 0L), r.array(0L, 1L))).with('type', 'LineString'))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("coordinates", r.array(r.array(0L, 0L), r.array(0L, 1L))).with("type", "LineString")),
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
            // geo/geojson.yaml line #8
            /* ({'$reql_type$':'GEOMETRY', 'coordinates':[[[0,0], [0,1], [1,0], [0,0]]], 'type':'Polygon'}) */
            Map expected_ = r.hashMap("$reql_type$", "GEOMETRY").with("coordinates", r.array(r.array(r.array(0L, 0L), r.array(0L, 1L), r.array(1L, 0L), r.array(0L, 0L)))).with("type", "Polygon");
            /* r.geojson({'coordinates':[[[0,0], [0,1], [1,0], [0,0]]], 'type':'Polygon'}) */
            logger.info("About to run line #8: r.geojson(r.hashMap('coordinates', r.array(r.array(r.array(0L, 0L), r.array(0L, 1L), r.array(1L, 0L), r.array(0L, 0L)))).with('type', 'Polygon'))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("coordinates", r.array(r.array(r.array(0L, 0L), r.array(0L, 1L), r.array(1L, 0L), r.array(0L, 0L)))).with("type", "Polygon")),
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
            // geo/geojson.yaml line #12
            /* err('ReqlQueryLogicError', 'Expected type NUMBER but found ARRAY.', [0]) */
            Err expected_ = err("ReqlQueryLogicError", "Expected type NUMBER but found ARRAY.", r.array(0L));
            /* r.geojson({'coordinates':[[], 0], 'type':'Point'}) */
            logger.info("About to run line #12: r.geojson(r.hashMap('coordinates', r.array(r.array(), 0L)).with('type', 'Point'))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("coordinates", r.array(r.array(), 0L)).with("type", "Point")),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #12");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #12:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // geo/geojson.yaml line #14
            /* err('ReqlQueryLogicError', 'Expected type ARRAY but found BOOL.', [0]) */
            Err expected_ = err("ReqlQueryLogicError", "Expected type ARRAY but found BOOL.", r.array(0L));
            /* r.geojson({'coordinates':true, 'type':'Point'}) */
            logger.info("About to run line #14: r.geojson(r.hashMap('coordinates', true).with('type', 'Point'))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("coordinates", true).with("type", "Point")),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #14");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #14:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // geo/geojson.yaml line #16
            /* err('ReqlNonExistenceError', 'No attribute `coordinates` in object:', [0]) */
            Err expected_ = err("ReqlNonExistenceError", "No attribute `coordinates` in object:", r.array(0L));
            /* r.geojson({'type':'Point'}) */
            logger.info("About to run line #16: r.geojson(r.hashMap('type', 'Point'))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("type", "Point")),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #16");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #16:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // geo/geojson.yaml line #18
            /* err('ReqlNonExistenceError', 'No attribute `type` in object:', [0]) */
            Err expected_ = err("ReqlNonExistenceError", "No attribute `type` in object:", r.array(0L));
            /* r.geojson({'coordinates':[0, 0]}) */
            logger.info("About to run line #18: r.geojson(r.hashMap('coordinates', r.array(0L, 0L)))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("coordinates", r.array(0L, 0L))),
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
            // geo/geojson.yaml line #20
            /* err('ReqlQueryLogicError', 'Unrecognized GeoJSON type `foo`.', [0]) */
            Err expected_ = err("ReqlQueryLogicError", "Unrecognized GeoJSON type `foo`.", r.array(0L));
            /* r.geojson({'coordinates':[0, 0], 'type':'foo'}) */
            logger.info("About to run line #20: r.geojson(r.hashMap('coordinates', r.array(0L, 0L)).with('type', 'foo'))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("coordinates", r.array(0L, 0L)).with("type", "foo")),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #20");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #20:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // geo/geojson.yaml line #22
            /* err('ReqlQueryLogicError', 'Unrecognized field `foo` found in geometry object.', [0]) */
            Err expected_ = err("ReqlQueryLogicError", "Unrecognized field `foo` found in geometry object.", r.array(0L));
            /* r.geojson({'coordinates':[0, 0], 'type':'Point', 'foo':'wrong'}) */
            logger.info("About to run line #22: r.geojson(r.hashMap('coordinates', r.array(0L, 0L)).with('type', 'Point').with('foo', 'wrong'))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("coordinates", r.array(0L, 0L)).with("type", "Point").with("foo", "wrong")),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #22");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #22:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // geo/geojson.yaml line #26
            /* ({'$reql_type$':'GEOMETRY', 'coordinates':[0, 0], 'type':'Point', 'crs':null}) */
            Map expected_ = r.hashMap("$reql_type$", "GEOMETRY").with("coordinates", r.array(0L, 0L)).with("type", "Point").with("crs", null);
            /* r.geojson({'coordinates':[0, 0], 'type':'Point', 'crs':null}) */
            logger.info("About to run line #26: r.geojson(r.hashMap('coordinates', r.array(0L, 0L)).with('type', 'Point').with('crs', null))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("coordinates", r.array(0L, 0L)).with("type", "Point").with("crs", null)),
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
            // geo/geojson.yaml line #30
            /* err('ReqlQueryLogicError', 'GeoJSON type `MultiPoint` is not supported.', [0]) */
            Err expected_ = err("ReqlQueryLogicError", "GeoJSON type `MultiPoint` is not supported.", r.array(0L));
            /* r.geojson({'coordinates':[0, 0], 'type':'MultiPoint'}) */
            logger.info("About to run line #30: r.geojson(r.hashMap('coordinates', r.array(0L, 0L)).with('type', 'MultiPoint'))");
            Object obtained = runOrCatch(r.geojson(r.hashMap("coordinates", r.array(0L, 0L)).with("type", "MultiPoint")),
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
    }
}
