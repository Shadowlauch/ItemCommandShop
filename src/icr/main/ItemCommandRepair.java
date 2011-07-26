package icr.main;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import icr.main.Update;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class ItemCommandRepair extends JavaPlugin {

	// PERMISSIONS
	private boolean UsePermissions;
	public static PermissionHandler Permissions;

	private void setupPermissions() {
		Plugin permtest = this.getServer().getPluginManager().getPlugin("Permissions");
		if (Permissions == null) {
			if (permtest != null) {
				UsePermissions = true;
				Permissions = ((Permissions) permtest).getHandler();
				log.info("[ItemCommandRepair] Permissions Plugin detected!");
			} else {
				log.info("[ItemCommandRepair] Permissions Plugin not detected.");
				UsePermissions = false;
			}
		}
	}
	private void testiCononmy(){
		Plugin icontest = this.getServer().getPluginManager().getPlugin("iConomy");
		if(icontest==null){
			this.getServer().getPluginManager().disablePlugin(this);
			log.info("[ItemCommandRepair] iConomy Plugin could not be detected. Disableing Plugin.");
		}
	}

	public boolean hasPerm(Player p, String string) {
		if (UsePermissions) {
			return Permissions.has(p, string);
		}
		return p.isOp();
	}

	// CONFIG
	public ConfigLoader config=new ConfigLoader(this);


	// LOG
	protected static final Logger log = Logger.getLogger("Minecraft");

	// ENABLE
	public void onEnable() {
		setupPermissions();
		testiCononmy();
		config.configCheck();
		log.info("[ItemCommandRepair] Version " + this.getDescription().getVersion()
				+ " by Shadowlauch enabled.");
		getCommand("commandrepair").setExecutor(new Commands(this));
		if(Update.getVersion()>Double.valueOf(this.getDescription().getVersion())){
			log.info("[ItemCOmmandRepair] >>> A new version is aviable! <<<");
		}
	}

	public void onDisable() {
		log.info("[ItemCommandRepair] Version " + this.getDescription().getVersion()
				+ " by Shadowlauch disabled.");
	}


}
