package icr.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.iConomy.*;
import com.iConomy.system.Account;
import com.iConomy.system.Holdings;

public class Commands implements CommandExecutor {
    private final ItemCommandRepair plugin;

      public Commands(ItemCommandRepair instance) {
      plugin = instance;
      }
      
      public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
          if(!(sender instanceof Player)) {
              return false;
          }
          Player p=(Player)sender;
          if(args.length == 0 || (args.length==1 && args[0].equals("repair"))) {
        	  if(plugin.hasPerm(p, "ItemCommandRepair.repair")){
        		  int type=p.getItemInHand().getTypeId();
        		  int dur=p.getItemInHand().getDurability();
        		  switch(type){
        		  	case 278:
        		  		setMoney(p,plugin.config.dp_rat,dur);break;
        		  	case 279:
        		  		setMoney(p,plugin.config.da_rat,dur);break;
        		  	case 277:
        		  		setMoney(p,plugin.config.dsh_rat,dur);break;
        		  	case 276:
        		  		setMoney(p,plugin.config.ds_rat,dur);break;
        		  	case 257:
        		  		setMoney(p,plugin.config.ip_rat,dur);break;
        		  	case 258:
        		  		setMoney(p,plugin.config.ia_rat,dur);break;
        		  	case 256:
        		  		setMoney(p,plugin.config.ish_rat,dur);break;
        		  	case 267:
        		  		setMoney(p,plugin.config.is_rat,dur);break;
        		  	case 283:
        		  		setMoney(p,plugin.config.gs_rat,dur);break;
        		  	case 284:
        		  		setMoney(p,plugin.config.gsh_rat,dur);break;
        		  	case 285:
        		  		setMoney(p,plugin.config.ga_rat,dur);break;
        		  	case 286:
        		  		setMoney(p,plugin.config.gp_rat,dur);break;
        		  	case 292:
        		  		setMoney(p,plugin.config.ih_rat,dur);break;
        		  	case 293:
        		  		setMoney(p,plugin.config.dh_rat,dur);break;
        		  	case 294:
        		  		setMoney(p,plugin.config.gh_rat,dur);break;
        		  	case 359:
        		  		setMoney(p,plugin.config.shears_rat,dur);break;
        		  		
        		  	case 302:
        		  		setMoney(p,plugin.config.cha_rat,dur);break;
        		  	case 303:
        		  		setMoney(p,plugin.config.cca_rat,dur);break;
        		  	case 304:
        		  		setMoney(p,plugin.config.cla_rat,dur);break;
        		  	case 305:
        		  		setMoney(p,plugin.config.cba_rat,dur);break;
        		  	case 306:
        		  		setMoney(p,plugin.config.iha_rat,dur);break;
        		  	case 307:
        		  		setMoney(p,plugin.config.ica_rat,dur);break;
        		  	case 308:
        		  		setMoney(p,plugin.config.ila_rat,dur);break;
        		  	case 309:
        		  		setMoney(p,plugin.config.iba_rat,dur);break;
        		  	case 310:
        		  		setMoney(p,plugin.config.dha_rat,dur);break;
        		  	case 311:
        		  		setMoney(p,plugin.config.dca_rat,dur);break;
        		  	case 312:
        		  		setMoney(p,plugin.config.dla_rat,dur);break;
        		  	case 313:
        		  		setMoney(p,plugin.config.dba_rat,dur);break;
        		  	case 314:
        		  		setMoney(p,plugin.config.gha_rat,dur);break;
        		  	case 315:
        		  		setMoney(p,plugin.config.gca_rat,dur);break;
        		  	case 316:
        		  		setMoney(p,plugin.config.gla_rat,dur);break;
        		  	case 317:
        		  		setMoney(p,plugin.config.gba_rat,dur);break;
        		  	default:
        		  	;	
        		  }
               	  return true;
        	  }
        	  else{
        		  Messages.send(p,ChatColor.RED + plugin.config.temp_nep);
        		  return true;
        	  }
          }
          if(args.length == 1) {
              String arg1 = args[0];
              if(arg1.equals("help")) {
            	  sender.sendMessage(ChatColor.GOLD + "===ItemCommandRepair Help=="); 
            	  if(plugin.hasPerm(p, "ItemCommandRepair.repair")){
            		  sender.sendMessage(ChatColor.GOLD + "/crp <repair>" + ChatColor.BLUE + " - Repair the Tool/Sword you are holding.");
            		  sender.sendMessage(ChatColor.GOLD + "/crp check" + ChatColor.BLUE + " - Returns the price to repair your Tool/Sword.");
            	  }
            	  if(plugin.hasPerm(p, "ItemCommandRepair.admin")){
            		  sender.sendMessage(ChatColor.GOLD + "/crp reload" + ChatColor.BLUE + " - Reloads the Config-File.");
            		  sender.sendMessage(ChatColor.GOLD + "/crp version" + ChatColor.BLUE + " - Shows the Version.");
            	  }
            	  return true;
              }
              if(arg1.equals("reload")) {
            	  if(plugin.hasPerm(p, "ItemCommandRepair.admin")){
            		  plugin.config.configCheck();
            		  sender.sendMessage(ChatColor.GOLD + "Config-File reloaded."); 
            	  }
            	  else Messages.send(p,ChatColor.RED + plugin.config.temp_nep);
            	  return true;
              }
              if(arg1.equals("version")) {
            	  if(plugin.hasPerm(p, "ItemCommandRepair.admin")){
            	  sender.sendMessage(ChatColor.GOLD + "Version: " + plugin.getDescription().getVersion()
				+ " by Shadowlauch"); 
            	  }
            	  else Messages.send(p,ChatColor.RED + plugin.config.temp_nep);
            	  return true;
              }
              if(arg1.equals("check")) {
	              if(plugin.hasPerm(p, "ItemCommandRepair.repair")){
	        		  int type=p.getItemInHand().getTypeId();
	        		  int dur=p.getItemInHand().getDurability();
	        		  switch(type){
	        		  	case 278:
	        		  		checkMoney(p,plugin.config.dp_rat,dur);break;
	        		  	case 279:
	        		  		checkMoney(p,plugin.config.da_rat,dur);break;
	        		  	case 277:
	        		  		checkMoney(p,plugin.config.dsh_rat,dur);break;
	        		  	case 276:
	        		  		checkMoney(p,plugin.config.ds_rat,dur);break;
	        		  	case 257:
	        		  		checkMoney(p,plugin.config.ip_rat,dur);break;
	        		  	case 258:
	        		  		checkMoney(p,plugin.config.ia_rat,dur);break;
	        		  	case 256:
	        		  		checkMoney(p,plugin.config.ish_rat,dur);break;
	        		  	case 283:
	        		  		checkMoney(p,plugin.config.gs_rat,dur);break;
	        		  	case 284:
	        		  		checkMoney(p,plugin.config.gsh_rat,dur);break;
	        		  	case 285:
	        		  		checkMoney(p,plugin.config.ga_rat,dur);break;
	        		  	case 286:
	        		  		checkMoney(p,plugin.config.gp_rat,dur);break;
	        		  	case 292:
	        		  		checkMoney(p,plugin.config.ih_rat,dur);break;
	        		  	case 293:
	        		  		checkMoney(p,plugin.config.dh_rat,dur);break;
	        		  	case 294:
	        		  		checkMoney(p,plugin.config.gh_rat,dur);break;
	        		  	case 359:
	        		  		checkMoney(p,plugin.config.shears_rat,dur);break;
	        		  	case 302:
	        		  		checkMoney(p,plugin.config.cha_rat,dur);break;
	        		  	case 303:
	        		  		checkMoney(p,plugin.config.cca_rat,dur);break;
	        		  	case 304:
	        		  		checkMoney(p,plugin.config.cla_rat,dur);break;
	        		  	case 305:
	        		  		checkMoney(p,plugin.config.cba_rat,dur);break;
	        		  	case 306:
	        		  		checkMoney(p,plugin.config.iha_rat,dur);break;
	        		  	case 307:
	        		  		checkMoney(p,plugin.config.ica_rat,dur);break;
	        		  	case 308:
	        		  		checkMoney(p,plugin.config.ila_rat,dur);break;
	        		  	case 309:
	        		  		checkMoney(p,plugin.config.iba_rat,dur);break;
	        		  	case 310:
	        		  		checkMoney(p,plugin.config.dha_rat,dur);break;
	        		  	case 311:
	        		  		checkMoney(p,plugin.config.dca_rat,dur);break;
	        		  	case 312:
	        		  		checkMoney(p,plugin.config.dla_rat,dur);break;
	        		  	case 313:
	        		  		checkMoney(p,plugin.config.dba_rat,dur);break;
	        		  	case 314:
	        		  		checkMoney(p,plugin.config.gha_rat,dur);break;
	        		  	case 315:
	        		  		checkMoney(p,plugin.config.gca_rat,dur);break;
	        		  	case 316:
	        		  		checkMoney(p,plugin.config.gla_rat,dur);break;
	        		  	case 317:
	        		  		checkMoney(p,plugin.config.gba_rat,dur);break;
	        		  	default:
	        		  	;	
	        		  }
	               	  return true;
	        	  }
	        	  else{
	        		  Messages.send(p,ChatColor.RED + plugin.config.temp_nep);
	        		  return true;
	        	  }
              }
          }
          return false;
       }
      private void setMoney(Player p, double rat, int dur){
    	  Account account = iConomy.getAccount(p.getName());
    	  Holdings balance = account.getHoldings();
    	  double mon=rat*dur;
    	  if(dur>0){
	    	  if(balance.hasEnough(mon)){
	    		  p.getItemInHand().setDurability((short) 0);
	    		  balance.subtract(mon);
	    		  Messages.send(p,ChatColor.GOLD + plugin.config.temp_rep.replaceAll("&pr", iConomy.format(mon)));
	    	  }
	    	  else{
	    		  Messages.send(p,ChatColor.RED + plugin.config.temp_nem); 
	    	  }
    	  }
    	  else Messages.send(p,ChatColor.RED + plugin.config.temp_nrn);
      }
      private void checkMoney(Player p, double rat, int dur){
    	  double mon=rat*dur;
    	  if(dur>0){
	    		  Messages.send(p,ChatColor.GOLD + plugin.config.temp_pri.replaceAll("&pr", iConomy.format(mon)));
    	  }
    	  else Messages.send(p,ChatColor.RED + plugin.config.temp_nrn); 
      }
}