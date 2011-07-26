package icr.main;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//import java.util.List;

import org.bukkit.util.config.Configuration;

public class ConfigLoader{
	    public ConfigLoader(ItemCommandRepair instance) {
	    }
	    File file=new File("plugins/ItemCommandRepair/config.yml");
	    public void configCheck(){
	        new File("plugins/ItemCommandRepair/").mkdir();
	        if(!file.exists()){
	            try {
	                file.createNewFile();
	                addDefaults();

	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        } else {

	            loadkeys();
	        }
	    }
/*	    private void write(String root, Object x){
	        Configuration config = load();
	        config.setProperty(root, x);
	        config.save();
	    }
	    private Boolean readBoolean(String root){
	        Configuration config = load();
	        return config.getBoolean(root, true);
	    }
	    private List<String> readStringList(String root){
	        Configuration config = load();
	        return config.getKeys(root);
	    }*/
	    private Double readDouble(String root){
	        Configuration config = load();
	        return config.getDouble(root, 0);
	    }
	    private String readString(String root){
	        Configuration config = load();
	        return config.getString(root);
	    }
	    private Configuration load(){

	        try {
	            Configuration config = new Configuration(file);
	            config.load();
	            return config;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    private void addDefaults(){
	        copyFile("config.yml", "plugins/ItemCommandRepair/config.yml");
	        ItemCommandRepair.log.info("[ItemCommandRepair] Generating Default Config File...");
	        loadkeys();
	    }
	    private void loadkeys(){
	    	dp_rat=readDouble("ratios.diamond.pickaxe");
	    	da_rat=readDouble("ratios.diamond.axe");
	    	dsh_rat=readDouble("ratios.diamond.shovel");
	    	ds_rat=readDouble("ratios.diamond.sword");
	    	dh_rat=readDouble("ratios.diamond.hoe");
	    	ip_rat=readDouble("ratios.iron.pickaxe");
	    	ia_rat=readDouble("ratios.iron.axe");
	    	ish_rat=readDouble("ratios.iron.shovel");
	    	is_rat=readDouble("ratios.iron.sword");
	    	ih_rat=readDouble("ratios.iron.hoe");
	    	gp_rat=readDouble("ratios.gold.pickaxe");
	    	ga_rat=readDouble("ratios.gold.axe");
	    	gsh_rat=readDouble("ratios.gold.shovel");
	    	gs_rat=readDouble("ratios.gold.sword");
	    	gh_rat=readDouble("ratios.gold.hoe");
	    	shears_rat=readDouble("ratios.others.shears");
	    	temp_rep=readString("templates.info.repaired");
	    	temp_pri=readString("templates.info.priceinfo");
	    	temp_nem=readString("templates.errors.notenoughmoney");
	    	temp_nrn=readString("templates.errors.notneedtorepair");
	    	temp_nep=readString("templates.errors.nopermissions");
	    }
	    void copy( InputStream in, OutputStream out ) throws IOException
	    {
	      byte[] buffer = new byte[ 0xFFFF ];

	      for ( int len; (len = in.read(buffer)) != -1; )
	        out.write( buffer, 0, len );
	      
	    }
	    void copyFile( String src, String dest )
	    {
	      InputStream  fis = null;
	      FileOutputStream fos = null;

	      try
	      {
	        fis = this.getClass().getResourceAsStream("/default/" + src);
	        fos = new FileOutputStream(dest);

	        copy( fis, fos );
	      }
	      catch ( IOException e ) {
	        e.printStackTrace();
	      }
	      finally {
	        if ( fis != null )
	          try { fis.close(); } catch ( IOException e ) { }
	        if ( fos != null )
	          try { fos.close(); } catch ( IOException e ) { e.printStackTrace(); }
	      }
	    }

		protected double dp_rat;
		protected double da_rat;
		protected double dsh_rat;
		protected double ds_rat;
		protected double dh_rat;
		protected double ip_rat;
		protected double ia_rat;
		protected double ish_rat;
		protected double is_rat;
		protected double ih_rat;
		protected double gp_rat;
		protected double ga_rat;
		protected double gsh_rat;
		protected double gs_rat;
		protected double gh_rat;
		protected double shears_rat;
		protected String temp_rep;
		protected String temp_pri;
		protected String temp_nem;
		protected String temp_nrn;
		protected String temp_nep;
		
}
