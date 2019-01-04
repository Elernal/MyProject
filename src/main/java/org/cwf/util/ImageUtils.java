package org.cwf.util;

import java.awt.Color;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;


/**
 * 

     * <p>Title : ImageUtils</p>

     * <p>Description : 验证码生成工具类</p>

     * <p>DevelopTools : Eclipse_x64_v4.7.1</p>

     * <p>DevelopSystem : macOS Sierra 10.12.1</p>

     * <p>Company : org.lin</p>

     * @author : guoxin

     * @date : 2018年12月6日 下午1:49:53
 */

public class ImageUtils {
	
	
	/**
	 * 
	 * @param width 图片宽
	 * @param height 图片高
	 * @param code  图片里面的文字
	 * @return  BufferedImage
	 */
	
	
	public static BufferedImage newImgCode(int width,int height,String code) {
		
		
		int size = code.length();
		
		
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		
		
		Graphics g = image.getGraphics();
		
		
		g.fillRect(0, 0, width, height);
		
		g.setFont(new Font("Arial",Font.CENTER_BASELINE,24));
		
		Random random = new Random();
		
		int goCount = 4;
		
		for (int i = 0; i <= size * goCount; i++) {
			
			int x = random.nextInt(width);
			
			int y = random.nextInt(height);
			
			int x1 = random.nextInt(13);
			
			int y1 = random.nextInt(15);
			
			g.drawLine(x,y,x+x1,y+y1);
			
		}
		
		
		String randomString = code;
		
		for (int i = 1; i <= size; i++) {
			
			
			
			g.setColor(new Color(random.nextInt(101),random.nextInt(111),random.nextInt(121)));
			
			g.drawString(randomString.charAt(i-1)+"", 18*i, 26);
			
			
		}
		
		return image;
		
	}
	
	
	/**
	 * 把图片转成流
	 * 
	 * @param bufferedImage 上面方法生成的图片
	 * @return  流
	 * @throws IOException
	 */
	
	public static InputStream getInputStream(BufferedImage bufferedImage) throws IOException {
	
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
		
		InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		
		
		return inputStream;
		
	}
	
	
	/**
	 * 生成随机验证码
	 * @return 验证码
	 */

public static String verifyCode(){
        String str = "";
        char[] ch = { '1', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                  'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y'};
        Random random = new Random();
        for (int i = 0; i <4; i++){
            char num = ch[random.nextInt(ch.length)];
            str += num;
        }
        return str;

}
	
	
}
