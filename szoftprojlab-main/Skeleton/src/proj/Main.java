import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;

import java.io.File;
import java.util.List;
import java.util.Random;

public class Main {
	
	public static boolean compare(String in, String out) {
		//String in, String out
		ArrayList<Field> fields=new ArrayList<Field>();
		int fieldnum=0;
		ArrayList<Virologist> virologists=new ArrayList<Virologist>();
		String temp;
		int virologistnum=0;
		Scanner sc= new Scanner(System.in); 
		String[]  command;
		Virologist main=null;
		Random rand=new Random();
		int k=0;
		int l=0;
		HashMap<String, Object> dictionary = new HashMap<String, Object>();
		String listall = new String();
		String statsall = new String();
		Scanner scanner = new Scanner(in);
		if(out.equals("NEMTESZT")) {
			scanner = sc;
		}
		
		while(scanner.hasNextLine())
		{
			temp = scanner.nextLine(); 
			
			command=temp.split(" ");
			
			
			switch (command[0])
			{
			 
			  case "list":
				  if(command.length==1)
				  {
					  ArrayList<Virologist> virologusok=new ArrayList<Virologist>();
					  for(int i=0; i<virologists.size();i++) {
						  virologusok.add(virologists.get(i));
					  }
					  if(!virologusok.isEmpty()) {
						  listall+=("virologist:[");
						  for(int i=0; i<virologusok.size();i++) {
							  listall+=(virologusok.get(i).getid());
							  if((i+1)<virologusok.size()) {
								  listall+=(", ");
							  }
						  }
						  listall+=("]\n");
					  }
					  ArrayList<Field> fieldek=new ArrayList<Field>();
					  for(int i=0; i<fields.size();i++) {
						  	fieldek.add(fields.get(i));
					  }
					  if(!fieldek.isEmpty()) {
						  listall+="field:[";
						  for(int i=0; i<fieldek.size();i++) {
							  listall+=(fieldek.get(i).getid());
							  if((i+1)<fieldek.size()) {
								  listall+=(", ");
							  }
						  }
						  listall+=("]\n");
					  }
					  ArrayList<String> agensek=new ArrayList<String>();
					  for(int i=0; i<virologists.size();i++) {
						  ArrayList<Agens> agens=virologists.get(i).getinventory().GetAgens();
						  for(int j=0; j<agens.size();j++) {
							  agensek.add(agens.get(i).getid());
						  }
					  }
					  if(!agensek.isEmpty()) {
					  listall+=("agens:[");
						  for(int i=0; i<agensek.size();i++) {
							  listall+=(agensek.get(i));
							  if((i+1)<agensek.size()) {
								  listall+=(", ");
							  }
						  }
						  listall+=("]\n");
					  }
					  ArrayList<String> gearek=new ArrayList<String>();
					  for(int i=0; i<virologists.size();i++) {
						  ArrayList<Gear> gears=virologists.get(i).getinventory().GetGears();
						  for(int j=0; j<gears.size();j++) {
							  gearek.add(gears.get(j).getid());
						  }
					  }
					  for(int i=0; i<fields.size();i++) {
						  if(fields.get(i).getClass()==new Refuge().getClass()) {
							  Gear gear=((Refuge) fields.get(i)).getGear();
							  if(gear!=null)
								  gearek.add(gear.getid());
						  }
					  }
					  if(!gearek.isEmpty()) {
						  listall+=("gears:[");
						  for(int i=0; i<gearek.size();i++) {
							  listall+=(gearek.get(i));
							  if((i+1)<gearek.size()) {
								  listall+=(", ");
							  }
						  }
						  listall+=("]\n");
					  }
					  ArrayList<String> codes=new ArrayList<String>();
					  for(int i=0; i<virologists.size();i++) {
						  ArrayList<Code> code=virologists.get(i).getcode();
						  for(int j=0; j<code.size();j++) {
							  boolean vanBenne=false;
							  for(int c=0; c<codes.size();c++)
								  if(code.get(i).getid().equals(codes.get(c)))
									  vanBenne=true;
							  if(!vanBenne)
								  codes.add(code.get(j).getid());
						  }
					  }
					  for(int i=0; i<fields.size();i++) {
						  if(fields.get(i).getClass()==new Laboratory().getClass()) {
							  Code code=((Laboratory) fields.get(i)).getCode();
							  boolean vanBenne=false;
							  for(int c=0; c<codes.size();c++)
								  if(code.getid().equals(codes.get(c)))
									  vanBenne=true;
							  if(!vanBenne)
								codes.add(code.getid());
						  }
					  }
					  if(!codes.isEmpty()) {
						  listall+=("code:[");
						  for(int i=0; i<codes.size();i++) {
							  listall+=(codes.get(i));
							  if((i+1)<codes.size()) {
								  listall+=(", ");
							  }
						  }
						  listall+=("]\n");
					  }
					  ArrayList<String> nukleotids=new ArrayList<String>();
					  ArrayList<String> aminoacid=new ArrayList<String>();
					  for(int i=0; i<virologists.size();i++) {
						  ArrayList<Material> mat=virologists.get(i).getinventory().getMaterial();
						  for(int j=0; j<mat.size();j++) {
							  if(mat.get(j).getClass()==new Nucleotid().getClass())
								  nukleotids.add(((Nucleotid) mat.get(j)).getId());
							  if(mat.get(j).getClass()==new AminoAcid().getClass())
								  aminoacid.add(((AminoAcid) mat.get(j)).getId());
						  }
					  }
					  for(int i=0; i<fields.size();i++) {
						  if(fields.get(i).getClass()==new Storage().getClass()) {
							  List<Material> mat=((Storage) fields.get(i)).mat;
							  for(int j=0; j<mat.size();j++) {
								  if(mat.get(j).getClass()==new Nucleotid().getClass())
									  nukleotids.add(((Nucleotid) mat.get(j)).getId());
								  if(mat.get(j).getClass()==new AminoAcid().getClass())
									  aminoacid.add(((AminoAcid) mat.get(j)).getId());
							  }
						  }
					  }
					  if(!nukleotids.isEmpty()) {
						  listall+=("nukleotid:[");
						  for(int i=0; i<nukleotids.size();i++) {
							  listall+=(nukleotids.get(i));
							  if((i+1)<nukleotids.size()) {
								  listall+=(", ");
							  }
						  }
						  listall+=("]\n");
					  }
					  if(!aminoacid.isEmpty()) {
						  listall+=("aminoacid:[");
						  for(int i=0; i<aminoacid.size();i++) {
							  listall+=(aminoacid.get(i));
							  if((i+1)<aminoacid.size()) {
								  listall+=(", ");
							  }
						  }
						  listall+=("]\n");
					  }
					  ArrayList<String> effects=new ArrayList<String>();
					  for(int i=0; i<virologists.size();i++) {
						  for(int j=0;j<virologists.get(i).getEffect().size();j++) {
							  effects.add(virologists.get(i).getEffect().get(j).getId());
						  }
					  }
					  if(!effects.isEmpty()) {
						  listall+=("effect:[");
						  for(int i=0; i<effects.size();i++) {
							  listall+=(effects.get(i));
							  if((i+1)<effects.size()) {
								  listall+=(", ");
							  }
						  }
						  listall+=("]\n");
					  } 
				  }
				  else if(command[1].equals("agens"))
				  {
					  boolean van=false;
					  listall+=("agensek:");
					  for(int i=0; i< virologists.size(); i++)
					  {
						  for(int j=0;j<virologists.get(i).getinventory().GetAgens().size() ;j++) {
							  listall+=(virologists.get(i).getinventory().GetAgens().get(j).getid());
							  van=true;
							  if(j+1<virologists.get(i).getinventory().GetAgens().size())
								  listall+=(", ");
						  }
					  }
					  if(van)
						  listall+=("\n");
					  else
						  listall+=("Nincs\n");

				  }//eddig jo
				  else if(command[1].equals("gear"))
				  {
					  listall+=("Felszerelesek:");
					  boolean van=false;
					  ArrayList<String> gearek=new ArrayList<String>();
					  for(int i=0; i<virologists.size();i++) {
						  ArrayList<Gear> gears=virologists.get(i).getinventory().GetGears();
						  for(int j=0; j<gears.size();j++) {
							  gearek.add(gears.get(i).getid());
						  }
					  }
					  for(int i=0; i<fields.size();i++) {
						  if(fields.get(i).getClass()==new Refuge().getClass()) {
							  Gear gear=((Refuge) fields.get(i)).getGear();
							  if(gear!=null)
								  gearek.add(gear.getid());
						  }
					  }
					  for(int i=0; i<gearek.size();i++) {
						  listall+=(gearek.get(i));
						  van=true;
						  if((i+1)<gearek.size()) {
							  listall+=(", ");
						  }
					  }
					  if(van)
						  listall+=("\n");
					  else
						  listall+=("Nincs\n");
				  }//eddig jo
				  else if(command[1].equals("character"))
				  {
					  listall+=("Virologusok:");
					  boolean van=false;
					  for(int i=0; i<virologists.size();i++) {
						  listall+=(virologists.get(i).getid());
						  van=true;
						  if((i+1)<virologists.size()) {
							  listall+=(", ");
						  }
					  }
					  if(van)
						  listall+=("\n");
					  else
						  listall+=("Nincs\n");
					  
				  }
				  else if(command[1].equals("material"))
				  {
					  listall+=("Nukleotid: ");
					  ArrayList<String> nukleotids=new ArrayList<String>();
					  ArrayList<String> aminoacid=new ArrayList<String>();
					  for(int i=0; i<virologists.size();i++) {
						  ArrayList<Material> mat=virologists.get(i).getinventory().getMaterial();
						  for(int j=0; j<mat.size();j++) {
							  if(mat.get(j).getClass()==new Nucleotid().getClass())
								  nukleotids.add(((Nucleotid) mat.get(j)).getId());
							  if(mat.get(j).getClass()==new AminoAcid().getClass())
								  aminoacid.add(((AminoAcid) mat.get(j)).getId());
						  }
					  }
					  for(int i=0; i<fields.size();i++) {
						  if(fields.get(i).getClass()==new Storage().getClass()) {
							  List<Material> mat=((Storage) fields.get(i)).mat;
							  for(int j=0; j<mat.size();j++) {
								  if(mat.get(j).getClass()==new Nucleotid().getClass())
									  nukleotids.add(((Nucleotid) mat.get(j)).getId());
								  if(mat.get(j).getClass()==new AminoAcid().getClass())
									  aminoacid.add(((AminoAcid) mat.get(j)).getId());
							  }
						  }
					  }
					  for(int i=0; i<nukleotids.size();i++) {
						  listall+=(nukleotids.get(i));
						  if((i+1)<nukleotids.size()) {
							  listall+=(", ");
						  }
					  }
					  if(nukleotids.size()==0)
						  listall+=("Nincs\n");
					  else
						  listall+=("\n");
					  listall+=("aminoacid:");
					  
					  for(int i=0; i<aminoacid.size();i++) {
						  listall+=(aminoacid.get(i));
						  if((i+1)<aminoacid.size()) {
							  listall+=(", ");
						  }
					  }
					  if(aminoacid.size()==0)
						  listall+=("Nincs\n");
					  else
						  listall+=("\n");
				  }//works
				  else if(command[1].equals("code"))
				  {
					  listall+=("Kod:");
					  ArrayList<String> codes=new ArrayList<String>();
					  for(int i=0; i<virologists.size();i++) {
						  ArrayList<Code> code=virologists.get(i).getcode();
						  for(int j=0; j<code.size();j++) {
							  boolean vanBenne=false;
							  for(int c=0; c<codes.size();c++)
								  if(code.get(i).getid().equals(codes.get(c)))
									  vanBenne=true;
							  if(!vanBenne)
								  codes.add(code.get(i).getid());
						  }
					  }
					  for(int i=0; i<fields.size();i++) {
						  if(fields.get(i).getClass()==new Laboratory().getClass()) {
							  Code code=((Laboratory) fields.get(i)).getCode();
							  boolean vanBenne=false;
							  for(int c=0; c<codes.size();c++)
								  if(code.getid().equals(codes.get(c)))
									  vanBenne=true;
							  if(!vanBenne)
								codes.add(code.getid());
						  }
					  }
					  for(int i=0; i<codes.size();i++) {
						  listall+=(codes.get(i));
						  if((i+1)<codes.size()) {
							  listall+=(", ");
						  }
					  }
					  if(codes.size()==0)
						  listall+=("Nincs\n");
					  else
						  listall+=("\n");
					  
				  }//works
				  else if(command[1].equals("field"))
				  {
					  listall+=("Mezok:");
					  if(fields.size()==0)
					  {
						  listall+=("Nincs!\n");
					  }
					  else
					  {
						  for(int i=0; i< fields.size(); i++)
						  {
							  listall+=(fields.get(i).id);
							  if(i+1<fields.size())
								  listall+=(", ");
						  }
					  }
					  listall+=("\n");
				  }
				  listall+=("\n");
				  break;
			  case "move":
				  for(int i=0;i<fields.size();i++) {
					  if(fields.get(i).id.equals(command[2])) {
						  main.Move(fields.get(i));
					  }
				  }
				  break;
			  case "code":
				  Agens ag2=null;
				  if(command[2].equals("Vaccine")) {
					  ag2=new Vaccine();
				  }
				  if(command[2].equals("StunV")) {
					  ag2=new StunV();
				  }
				  if(command[2].equals("VitusDanceV")) {
					  ag2=new VitusDanceV();
				  }
				  if(command[2].equals("MemoryLossV")) {
					  ag2=new MemoryLossV();
				  }
				  if(ag2!=null) {
					  ag2.setid("mlV");
					  Code c = new Code(3,3,ag2);
					  c.setid(command[1]);
					  for(int i=0;i<virologists.size();i++) {
							 if(virologists.get(i).getid().equals(command[3])) virologists.get(i).Touch(c);;
					  }
				  }
				  //main.Touch(c);
				  break;
				  //works
			  case "turn"://nemworks
				  if(command.length==1)
				  {
					 int jelenleg=0;
					 for(int i=0;i<virologists.size();i++) {
						 if(virologists.get(i).equals(main)) jelenleg=i;
					 }
					 if(jelenleg==virologists.size()-1) jelenleg=0;
					 else jelenleg++;
					 main=virologists.get(jelenleg);
				  }
				  else if(command.length==2)
				  {
						 for(int i=0;i<virologists.size();i++) {
							 if(virologists.get(i).id.equals(command[1])) main=virologists.get(i);
						 }
				  }
				  main.Step();
				  break;
			  case "virologist":
				  if(command.length==2)
				  {
					  virologists.add(new Virologist());
					  virologists.get(virologists.size()-1).id=command[1];
					  if(virologists.size()==1) main=virologists.get(virologists.size()-1);
					  
					  
				  }
				  else if(command.length==3)
				  {
					  virologists.add(new Virologist());
					  virologists.get(virologists.size()-1).id=command[1];
					  for(int i =0;i<fields.size();i++) {
						  if(fields.get(i).id.equals(command[2])) {
							  fields.get(i).Accept(
					  virologists.get(virologists.size()-1));
							  virologists.get(virologists.size()-1).setFields(fields.get(i));
						  }
					  }
				  }
				  break;
			  case "field":
				  if(command[2].equals("laboratory"))
				  {
					  fields.add(new Laboratory());
				  }
				  else if(command[2].equals("refuge"))
				  {
					  fields.add( new Refuge());
				  }
				  else if(command[2].equals("storage"))
				  {
					  fields.add( new Storage());
				  }
				  else if(command[2].equals("Empty"))
				  {
					  fields.add(  new Field());
				  }

				  if(fields.size() > 0) {
					  fields.get(fields.size()-1).setid(command[1]);  
					  dictionary.put(fields.get(fields.size()-1).getid(), fields.get(fields.size()-1));
				  }			  
				  //fields.get(fields.size()-1).setid(command[1]);

				  break;
				  //wrosks
			  case "craft":
				  for(int i =0;i<main.getcode().size();i++) {
					  if(main.getcode().get(i).getid().equals(command[1])) {
						  main.Craft(main.getcode().get(i));
					  }
				  }
				  break;
				  //works
			  case "takegearoff":
				  for(int i =0;i<main.getinventory().GetGears().size();i++) {
					  if(main.getinventory().GetGears().get(i).getid().equals(command[1]))
						  main.TakeGearOff(main.getinventory().GetGears().get(i));
				  }
				  
				  break;
				  //works
				 /**<AminoAcid> setfield <f1>
item <nu1> <Nucleotid>**/
			  case "item"://kell rakni fieldre itemet,matrialt,virologushoz adni matrialt
				  for(int i=0;i<virologists.size();i++) {//cape axe glove backpack
					  if(virologists.get(i).id.equals(command[4])) {
						  if(command[2].equals("Nucleotid")) {
							  Nucleotid nuc= new Nucleotid();
							  nuc.id=command[1];
							  virologists.get(i).getinventory().AddMaterial(nuc);
						  }
						  if(command[2].equals("AminoAcid")) {
							  AminoAcid nuc= new AminoAcid();
							  nuc.id=command[1];
							  virologists.get(i).getinventory().AddMaterial(nuc);
						  }
						  if(command[2].equals("Cape")) {
							  virologists.get(i).getinventory().AddGear(new Cape());
							  virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1).id=command[1];
							  virologists.get(i).AddEffect(((Cape) virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1)).getCe());
							  virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1).setid("c1");
						  }
						  if(command[2].equals("Axe")) {
							  virologists.get(i).getinventory().AddGear(new Axe());
							  virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1).id=command[1];
							  virologists.get(i).AddEffect(((Axe) virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1)).GetEffect());
							  virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1).setid("a1");

						  }
						  if(command[2].equals("Glove")) {
							  virologists.get(i).getinventory().AddGear(new Glove());
							  virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1).id=command[1];
							  virologists.get(i).AddEffect(((Glove) virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1)).getGe());
							  virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1).setid("g1");

						  }
						  if(command[2].equals("BackPack")) {
							  virologists.get(i).getinventory().AddGear(new BackPack());
							  virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1).id=command[1];
							  virologists.get(i).AddEffect(((BackPack) virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1)).getPbe());
							  virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1).setid("b1");
						  }
						  if(virologists.get(i).getinventory().GetGears().size()>0) {
							  if(virologists.get(i).getinventory().GetGears().size()==0)virologists.get(i).getinventory().GetGears().get(virologists.get(i).getinventory().GetGears().size()-1).setid(command[1]);
						  }
					}
				  }
				  for(int i=0;i<fields.size();i++) {
					  if(command[4].equals(fields.get(i).id)){
						  if(command[2].equals("Cape")) {
							  Refuge re=(Refuge) fields.get(i);
							re.setGear(new Cape());
							re.getGear().id="c1";
						  }
						  if(command[2].equals("Axe")) {
							  Refuge re=(Refuge) fields.get(i);
							  re.setGear(new Axe());
							  re.getGear().id="a1";
						  }
						  if(command[2].equals("Glove")) {
							  Refuge re=(Refuge) fields.get(i);
							  re.setGear(new Glove());
							  re.getGear().id="g1";
						  }
						  if(command[2].equals("BackPack")) {
							  Refuge re=(Refuge) fields.get(i);
							  re.setGear(new BackPack());
							  re.getGear().id="b1";
						  }
						  if(command[2].equals("Nucleotid")) {
							  Storage stor = (Storage) fields.get(i);
							  Nucleotid nuc= new Nucleotid();
							  nuc.id=command[1];
							  stor.mat.add(nuc);
						  }
						  if(command[2].equals("AminoAcid")) {
							  Storage stor = (Storage) fields.get(i);
							  AminoAcid nuc= new AminoAcid();
							  nuc.id=command[1];
							  stor.mat.add(nuc);
						  }
					  }
				  }
				  break;
			  case "neighbours":
				  k=0;
				  for(int i=0;i<fields.size();i++) {
					  for(int x=0;x<fields.size();x++)
						  for(int j=0;j<command.length;j++)
					  if(fields.get(i).getid().equals(command[1]) && fields.get(x).getid().equals(command[j])) {

						  if(x!=i)fields.get(i).addNeighbour(fields.get(x));
						  if(x!=i) fields.get(x).addNeighbour(fields.get(i));

					  }
				  }//mukszik
				  break;
			  case "pickup":
				  if(main.getField()!=null)
					  main.PickUp();
				  break;
			  case "steal":
			  		Virologist v2=null;
			  		for(int i=0; i<virologists.size();i++) {
			  			if(virologists.get(i).getid().equals(command[1]))
			  				v2=virologists.get(i);
			  		}
			  		Gear gear=null;
			  		for(int i=0; i<v2.getinventory().GetGears().size();i++) {
			  			if(v2.getinventory().GetGears().get(i).getid().equals(command[2])) {
			  				gear=v2.getinventory().GetGears().get(i);
			  			}
			  		}
			  		if(v2!=null&&gear!=null) {
			  				main.Steal(v2, gear);
			  		}
			  case "effect":
				  		Effect e=null;
						  if(command[2].equals("VirusResistentEffect")) {
							  e=new VirusResistentEffect();
						  }
						  if(command[2].equals("GloveEffect")) {
							  e=new GloveEffect();
						  }
						  if(command[2].equals("CapeEffect")) {
							  e=new CapeEffect();
						  }
						  if(command[2].equals("BackPackEffect")) {
							  e=new BackPackEffect();
						  }
						  if(command[2].equals("VirusDanceEffect")) {
							  e=new VirusDanceEffect();
						  }
						  if(command[2].equals("ParalyzedEffect")) {
							  e=new ParalyzedEffect();
						  }
						  if(command[2].equals("AxeEffect")) {
							  e=new AxeEffect();
						  }
						  if(command[2].equals("MaciEffekt")) {
							  e=new MaciEffekt();
						  }
					if(command.length>=3&&e!=null) {
						for(int i=0;i<virologists.size();i++) {
							if(virologists.get(i).id.equals(command[3])) {
								virologists.get(i).AddEffect(e);
							 	virologists.get(i).getEffect().get(virologists.get(i).getEffect().size()-1).id=command[1];
							 }
						}
					}
				  break;
				  
			  case "attackwaxe"://nincsen ellenorizve
				  k=0;
				  for(int i=0;i<virologists.size();i++) {
					  if(virologists.get(i).id.equals(command[1])) {
						  main.UseAxe(virologists.get(i));
						  virologists.remove(i);
					  }
				  }
				  break;
			  case "attack":
				  Agens agens=null;
			  		for(int i=0; i<main.getinventory().GetAgens().size();i++) {
			  			if(main.getinventory().GetAgens().get(i).getid().equals(command[1]))
			  				agens=main.getinventory().GetAgens().get(i);
			  		}
				  if(main.getid().equals(command[2]) && agens!=null) {
					  main.SelfAttack(agens);
				  }
				  else {
				  		Virologist v3=null;
				  		for(int i=0; i<virologists.size();i++) {
				  			if(virologists.get(i).getid().equals(command[2]))
				  				v3=virologists.get(i);
				  		}
				  		if(agens!=null && v3!=null) {
				  			if(command.length>3 &&command[3].equals("true"))
				  				main.Attack(agens, v3, true);
				  			else
				  				main.Attack(agens, v3, false);
				  		}
				  }
				  break;
			  case "agens":
				  Agens ag=null;
				  if(command[2].equals("Vaccine")) {
					  ag=new Vaccine();
				  }
				  if(command[2].equals("StunV")) {
					  ag=new StunV();
				  }
				  if(command[2].equals("VitusDanceV")) {
					  ag=new VitusDanceV();
				  }
				  if(command[2].equals("MemoryLossV")) {
					  ag=new MemoryLossV();
				  }
					if(command.length>=3&&ag!=null) {
						for(int i=0;i<virologists.size();i++) {
							if(virologists.get(i).id.equals(command[3])) {
								virologists.get(i).getinventory().AddAgens(ag);
								virologists.get(i).getinventory().GetAgens().get(virologists.get(i).getinventory().GetAgens().size()-1).id=command[1];
							 }
						}
					}
			  break;
			  case "stat"://AGENS,TARGY,EFFEKT
				  boolean kiir=false;
				  //AGENS
				  for(int i=0; i<virologists.size();i++) {
					  for(int j=0; j<virologists.get(i).getinventory().GetAgens().size();j++) {
						  if(virologists.get(i).getinventory().GetAgens().get(j).getid().equals(command[1])) {
							  		statsall+=("\nagens:");
							  		statsall+=("\nid:"+command[1]);
							  		statsall+=("\ntype: [");
							  		if(virologists.get(i).getinventory().GetAgens().get(j).getClass().equals(new StunV().getClass())) {
							  			statsall+=("StunV]");
							  		}//stun,vakcina,vitusdance,memoryloss
							  		if(virologists.get(i).getinventory().GetAgens().get(j).getClass().equals(new MemoryLossV().getClass())) {
							  			statsall+=("MemoryLossV]");
							  		}
							  		if(virologists.get(i).getinventory().GetAgens().get(j).getClass().equals(new VitusDanceV().getClass())) {
							  			statsall+=("VitusDanceV]");
							  		}
							  		if(virologists.get(i).getinventory().GetAgens().get(j).getClass().equals(new Vaccine().getClass())) {
							  			statsall+=("Vaccine]");
							  		}
							  		statsall+=("\nduration:"+virologists.get(i).getinventory().GetAgens().get(j).duration);
						  }	  
					  }
				  }
				  int cout=0;
				  for(int i=0;i<virologists.size();i++) {
					  if(virologists.get(i).id.equals(command[1])) {
					  statsall+=("virologist:"+"\n");
					  statsall+=("id: "+virologists.get(i).id+"\n");
					  statsall+=("code: [");
					  kiir=true;
					  
				  for(int j=0;j<virologists.get(i).getcode().size();j++) {
					  statsall+=(virologists.get(i).getcode().get(j).getid());
					  if(j!=virologists.get(i).getcode().size()-1)statsall+=(", ");
				  }
				  statsall+=("]\n");
				  //------
				  statsall+=("gears: [");
				  for(int j=0;j<virologists.get(i).getinventory().GetGears().size();j++) {
					  statsall+=(virologists.get(i).getinventory().GetGears().get(j).getid());
					  if(j!=virologists.get(i).getinventory().GetGears().size()-1)statsall+=(", ");
				  }
				  statsall+=("]\n");
				  //----
				  statsall+=("nucleotid: [");
					for(int j=0;j<virologists.get(i).getinventory().getMaterial().size();j++) 
					{
						int a=virologists.get(i).getinventory().getMaterial().get(j).Accept(new MaterialVisitor());
						if(a==2) {
							if(cout!=0)statsall+=(", ");
							Nucleotid n =(Nucleotid) virologists.get(i).getinventory().getMaterial().get(j);
							cout=1;
							statsall+=(n.getId());
						}
					}
					statsall+=("]\n");
					cout=0;
				
					//----
					statsall+=("aminoacid: [");
					for(int j=0;j<virologists.get(i).getinventory().getMaterial().size();j++) 
					{
						int a=virologists.get(i).getinventory().getMaterial().get(j).Accept(new MaterialVisitor());
						if(a==1) {
							if(cout!=0)statsall+=(", ");
							AminoAcid n =(AminoAcid) virologists.get(i).getinventory().getMaterial().get(j);
							cout=1;
							statsall+=(n.getId());
						}
					}
					statsall+=("]\n");
					cout=0;
				
				//----
					statsall+=("agens: [");
				  for(int j=0;j<virologists.get(i).getinventory().GetAgens().size();j++) {
					  statsall+=(virologists.get(i).getinventory().GetAgens().get(j).getid());
					  if(j!=virologists.get(i).getinventory().GetAgens().size()-1)statsall+=(", ");
				  }
				  statsall+=("]\n");
				  
				//----
				  statsall+=("effects: [");
				  for(int j=0;j<virologists.get(i).getEffect().size();j++) {
					  statsall+=(virologists.get(i).getEffect().get(j).getId());
					  if(j!=virologists.get(i).getEffect().size()-1)statsall+=(", ");
				  }
				  statsall+=("]\n");
				  }
				  }
				  //INNENTOL FIELD
				  for(int i=0;i<fields.size();i++) {
					  if(fields.get(i).id.equals(command[1])) {
					  statsall+=("field:\n");
					  statsall+=("id: "+fields.get(i).id+"\n");
					  statsall+=("Type: ");
					  int type=0;
					  if(fields.get(i).getClass()==new Refuge().getClass()) {
						  statsall+=("refuge");
						  type=1;
					  }
					  else if(fields.get(i).getClass()==new Laboratory().getClass()) {
						  statsall+=("laboratory");
						  type=2;
					  }
					  else if(fields.get(i).getClass()==new Storage().getClass()) {
						  statsall+=("storage");
						  type=3;
					  }
					  else statsall+=("empty");
					  statsall+=("\nCode: [");
					  if(type==2) {
						  Laboratory lab= (Laboratory)fields.get(i);
						  statsall+=(lab.getCode().getid());
					  }
					  statsall+=("]\n");
					  statsall+=("Gears: [");
					  if(type==1) {
						  Refuge lab= (Refuge)fields.get(i);
						  if(lab.getGear()!=null)statsall+=(lab.getGear().getid());
					  }
					  statsall+=("]\n");
					  statsall+=("nucleotid: [");
					  cout=0;
					  if(type==3) {
						  Storage lab = (Storage)fields.get(i);
						  for(int f1=0;f1<lab.mat.size();f1++) {
							  int a=lab.mat.get(f1).Accept(new MaterialVisitor());
								if(a==2) {
									if(cout!=0)statsall+=(", ");
									Nucleotid n =(Nucleotid) lab.mat.get(f1);
									cout=1;
									statsall+=(n.getId());
								}
						  }
					  }
					  statsall+=("]\n");
					//----
					  statsall+=("aminoacid: [");
					  cout=0;
					  if(type==3) {
						  Storage lab = (Storage)fields.get(i);
						  for(int f1=0;f1<lab.mat.size();f1++) {
							  int a=lab.mat.get(f1).Accept(new MaterialVisitor());
								if(a==1) {
									if(cout!=0)statsall+=(", ");
									AminoAcid n =(AminoAcid) lab.mat.get(f1);
									cout=1;
									statsall+=(n.getId());
								}
						  }
					  }
					  statsall+=("]\n");
					//----
					  statsall+=("virologist on the filed: [");
					  for(int f1=0;f1<fields.get(i).getVirologist().size();f1++) {
						  statsall+=(fields.get(i).getVirologist().get(f1).id);
						  if(f1!=fields.get(i).getVirologist().size()-1)statsall+=(", ");
					  }
					  statsall+=("]\n");
					//----
					  statsall+=("neighbours: [");
					  for(int f1=0;f1<fields.get(i).getNeighbors().size();f1++) {
						  statsall+=(fields.get(i).getNeighbors().get(f1).id);
						  if(f1!=fields.get(i).getNeighbors().size()-1)statsall+=(", ");
					  }
					  statsall+=("]\n");
				  }
				  }
				  //TARGY
				  /**
				  for(int i=0;i<virologists.size();i++) {
					  for(int f=0;f<virologists.get(i).getinventory().GetGears().size();f++) {
						  if(virologists.get(i).getinventory().GetGears().get(f).id.equals(command[1])) {
							  
						  }
					  }
				  }
				  **/
				  //EFFECT
				  for(int i=0;i<virologists.size();i++) {
					  for(int f=0;f<virologists.get(i).getEffect().size();f++) {
						  if(virologists.get(i).getEffect().get(f).id!=null)
						  if(virologists.get(i).getEffect().get(f).id.equals(command[1])) {
							  statsall+=("\neffect:");
							  statsall+=("\nid: ["+virologists.get(i).getEffect().get(f).id+"]");
							  statsall+=("\nduration: ["+virologists.get(i).getEffect().get(f).duration+"]");
							  statsall+=("\ntype: [");
								EffectVisitor visit= new EffectVisitor();
								if(virologists.get(i).getEffect().get(f).Accept(visit)==1)
								{
									statsall+=("BackPackEffect");
								}
								if(virologists.get(i).getEffect().get(f).Accept(visit)==2)
								{
									statsall+=("GloveEffect");
								}
								if(virologists.get(i).getEffect().get(f).Accept(visit)==3)
								{
									statsall+=("CapeEffect");
								}
								if(virologists.get(i).getEffect().get(f).Accept(visit)==4)
								{
									statsall+=("VirusResistentEffect");
								}
								if(virologists.get(i).getEffect().get(f).Accept(visit)==5)
								{
									statsall+=("VitusDanceEffect");
								}
								if(virologists.get(i).getEffect().get(f).Accept(visit)==6)
								{
									statsall+=("ParalyzedEffect");
								}
								if(virologists.get(i).getEffect().get(f).Accept(visit)==7)
								{
									statsall+=("MaciEffect");
								}
								if(virologists.get(i).getEffect().get(f).Accept(visit)==8)
								{
									statsall+=("AxeEffect");
								}
								statsall+=("]");
						  }
					  }
				  }
				  statsall+=("\n");
				  //System.out.println(statsall);
				  break;
			}
			if(out.equals("NEMTESZT")) {
				System.out.println(listall);
				System.out.println(statsall);
				listall = new String();
				statsall = new String();
			}
		}
		if(!out.equals("NEMTESZT")) {
			String testout = new String();
			testout+=listall;
			testout+=statsall;
			scanner.close();
			
			if(out.compareTo(testout) == 0) {
				System.out.println("-----------Successful------------\n");
				return true;
			}
			else {
				System.out.println("------------Expected------------");
				System.out.println(out);
				System.out.println("---------------Got--------------");
				System.out.println(testout);
				System.out.println("--------------------------------\n");
				return false;
			}
		}
		return false;
	}
	
	public static String inputreader(String name) {
		String in = new String();
		
		try {
	      File myObj = new File("./init/"+name);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	    	in += (myReader.nextLine() + "\n" );
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
		in = in.replace("<", "");
		in = in.replace(">", "");
		
		return in;
	}
	
	public static String outputreader(String name) {
		String out = new String();
		System.out.println("Test: " + name);
		try {
	      File myObj = new File("./output/"+name);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	    	  out += (myReader.nextLine() + "\n" );
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
		
		return out;}
	public static void main(String[] args) { 
		GameController gc= new GameController();
		gc.initmap();
		gc.init();
	}
}
