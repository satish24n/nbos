package com.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliAS {
	
	public boolean imageComparision(String srcImageLocation, WebElement element){
		
		Screen screen = new Screen();
		Pattern pattern = new Pattern(srcImageLocation);
		boolean retval = false;
		
		screen.capture().save("E:/test/scap");
		
		Finder finder = new Finder(screen.capture().getImage());
		String finderResult = finder.find(pattern);
		
		System.out.println("Image Location stored in finder: "+ finderResult);
		
		if(finder.hasNext()){			
			Match m = finder.next();
			retval= true;
			System.out.println("Match found with "+(m.getScore()*100 +"%"));
			finder.destroy();
		}
		else{			
			System.err.println("No Match Found");
		}		
				
		return retval;
	}

}
