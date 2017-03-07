package equinooxe.job;

import java.time.LocalDateTime;

import equinooxe.deployer.AppConfig;
import equinooxe.deployer.CommandRunner;

public class MySqlExporterJob implements Executable {
	@Override
	public String run() {
		System.out.println("...Exporting Database ...");
		return CommandRunner.run(getCommand(), shouldRollback());
	}

	@Override
	public boolean shouldRollback() {
		return false;
	}
	/**
	 * @return
	 */
	public String getCommand(){
		String cmd=  
				" mysqldump -h"+AppConfig.MYSQL_HOSTNAME 
				+ " -u"+AppConfig.MYSQL_USER
				+ " -p"+AppConfig.MYSQL_PASSWORD
				+ " --single-transaction "
				+ " "+ AppConfig.MYSQL_DBNAME+" | gzip > "
				+ AppConfig.DB_BACKUP_FOLDER+"/"+AppConfig.MYSQL_DBNAME+"."+LocalDateTime.now().toString()+".sql.gz "
				 ;   
     return cmd;
	}
	
}
