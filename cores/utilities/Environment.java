package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;;

@Sources({ "classpath:${env}.properties" })
public interface Environment extends Config {

	@Key("db.url")
	String getAppUrl();

	@Key("db.user")
	String getAppUsername();

	@Key("db.password")
	String getAppPassword();
}
