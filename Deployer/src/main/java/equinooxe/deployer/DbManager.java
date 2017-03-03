package equinooxe.deployer;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;

public class DbManager {
   public static void init() {
	   DB db = DBMaker.fileDB("file.txt").make();
	   ConcurrentMap map = db.hashMap("map").createOrOpen();
	   map.put("something", LocalDateTime.now().toString());
	   db.close();
   }
}
