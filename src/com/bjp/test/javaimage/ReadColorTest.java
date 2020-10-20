package com.bjp.test.javaimage;

import java.awt.AWTException;  
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;  
import java.awt.Robot;  
import java.awt.Toolkit;  
import java.awt.image.BufferedImage;  
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;  
  
public class ReadColorTest {  
    /** 
     * 读取一张图片的RGB值 
     *  
     * @throws Exception 
     */  
    public void getImagePixel(String image) throws Exception {  
        int[] rgb = new int[3];  
        File file = new File(image);  
        BufferedImage bi = null;  
        try {  
            bi = ImageIO.read(file);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        int width = bi.getWidth();  
        int height = bi.getHeight();  
        int minx = bi.getMinX();  
        int miny = bi.getMinY();  
        System.out.println("width=" + width + ",height=" + height + ".");  
        System.out.println("minx=" + minx + ",miniy=" + miny + ".");  
        for (int i = minx; i < width; i++) {  
            for (int j = miny; j < height; j++) {  
                int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字  
                rgb[0] = (pixel & 0xff0000) >> 16;  
                rgb[1] = (pixel & 0xff00) >> 8;  
                rgb[2] = (pixel & 0xff);  
                System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","  
                        + rgb[1] + "," + rgb[2] + ")");  
            }  
        }  
    }  
  
    /** 
     * 返回屏幕色彩值 
     *  
     * @param x 
     * @param y 
     * @return 
     * @throws AWTException 
     */  
    public int getScreenPixel(int x, int y) throws AWTException { // 函数返回值为颜色的RGB值。  
        Robot rb = null; // java.awt.image包中的类，可以用来抓取屏幕，即截屏。  
        rb = new Robot();  
        Toolkit tk = Toolkit.getDefaultToolkit(); // 获取缺省工具包  
        Dimension di = tk.getScreenSize(); // 屏幕尺寸规格  
        System.out.println(di.width);  
        System.out.println(di.height);  
        Rectangle rec = new Rectangle(0, 0, di.width, di.height);  
        BufferedImage bi = rb.createScreenCapture(rec);  
        int pixelColor = bi.getRGB(x, y);  
  
        return 16777216 + pixelColor; // pixelColor的值为负，经过实践得出：加上颜色最大值就是实际颜色值。  
    }  
    //修改像素值
    public void setAlpha(String os) {
        /**
         * 增加测试项
         * 读取图片，绘制成半透明,修改像素
         */
        try {
          ImageIcon imageIcon = new ImageIcon(os);
          BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(),imageIcon.getIconHeight()
              , BufferedImage.TYPE_4BYTE_ABGR);
          Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
          g2D.drawImage(imageIcon.getImage(), 0, 0,
                               imageIcon.getImageObserver());
          //循环每一个像素点，改变像素点的Alpha值
          int alpha = 100;
          for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {
            for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {
              int pixel = bufferedImage.getRGB(j2, j1);
              int[]   rgb = new int[3];
              rgb[0] = (pixel & 0xff0000) >> 16;
              rgb[1] = (pixel & 0xff00) >> 8;
              rgb[2] = (pixel & 0xff);
              System.out.println("i=" + j1 + ",j=" + j2 + ":(" + rgb[0] + ","
                        + rgb[1] + "," + rgb[2] + ")");

              pixel = ( (alpha + 1) << 24) | (pixel & 0x00ffffff);
              bufferedImage.setRGB(j2, j1, pixel);
            }
          }
          g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());

          //生成图片为PNG
          ImageIO.write(bufferedImage, "jpg",  new File("D:\\xiao.jpg"));
        }
        catch (Exception e) {
          e.printStackTrace();
        }
    }
    
    /**
     * @param imagePath 要灰化图像的名字
     * @param path 生成的图像的名字
     * 
     */
    public void transformGray_R(String imagePath, String path) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imagePath));
            for(int y = image.getMinY(); y  < image.getHeight(); y++) {
                for(int x = image.getMinX(); x < image.getWidth(); x ++) {
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0x00ff;
                    pixel = (r & 0x000000ff) | (pixel & 0xffffff00); //用r的值设置b的值
                    pixel = ((r<<8) & 0x0000ff00) | (pixel & 0xffff00ff);//用r的值设置g的值
                    image.setRGB(x, y, pixel);
                }
            }
            try {
                ImageIO.write(image, "jpg", new File(path));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }
    
    //加权法
    public void transformGrayJiaQuan (String imagePath, String path) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            int width = image.getWidth();
            int height = image.getHeight();
            for(int y = image.getMinY(); y < height; y++) {
                for(int x = image.getMinX(); x < width ; x ++) {
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0xff;
                    int g = (pixel >> 8) & 0xff;
                    int b = pixel & 0xff;
                    //加权法的核心,加权法是用图片的亮度作为灰度值的
                    int grayValue = (int) (0.30f * r + 0.59f * g + 0.11f * b ); 
                    //int grayValue = (int) (0.21f * 4 + 0.71f * g + 0.08f * b); //还可以使用这个系数的加权法
                    pixel = (grayValue << 16) & 0x00ff0000 | (pixel & 0xff00ffff);   //r
                    pixel = (grayValue << 8) & 0x0000ff00 | (pixel & 0xffff00ff    );//g
                    pixel = (grayValue) & 0x000000ff | (pixel & 0xffffff00);		 //b
                    image.setRGB(x, y, pixel);
                }
            }
            
            ImageIO.write(image, "jpg", new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    /**
     * @param imagePath 需要进行处理的图像名字
     * @param path 生成的图像的名字
     * 
     */
    public void transformImage(String imagePath, String path) {
    	try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            int width = image.getWidth();
            int height = image.getHeight();
            for(int y = image.getMinY(); y < height; y++) {
                for(int x = image.getMinX(); x < width ; x ++) {
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0xff;
                    int g = (pixel >> 8) & 0xff;
                    int b = pixel & 0xff;
                    int newR = 255;
                    int newG = 255;
                    int newB = 255;
//                    if((r > 80 && r < 150) && 
//                    		(g > 80 && g < 150) &&
//                    		(b > 80 && b < 150))
                    if((r >=250 ) && (g >=0 &&g <= 10) && (b >=0 &&b <= 10)){
                    	newR = 0;
                    	newG = 0;
                    	newB = 0;
                    	pixel = (newR << 16) & 0x00ff0000 | (pixel & 0xff00ffff);   //r
                        pixel = (newG << 8) & 0x0000ff00 | (pixel & 0xffff00ff    );//g
                        pixel = (newB) & 0x000000ff | (pixel & 0xffffff00);		 //b
                    }
                    //加权法的核心,加权法是用图片的亮度作为灰度值的
//                    int grayValue = (int) (0.30f * r + 0.59f * g + 0.11f * b ); 
                    //int grayValue = (int) (0.21f * 4 + 0.71f * g + 0.08f * b); //还可以使用这个系数的加权法
                    pixel = (newR << 16) & 0x00ff0000 | (pixel & 0xff00ffff);   //r
                    pixel = (newG << 8) & 0x0000ff00 | (pixel & 0xffff00ff    );//g
                    pixel = (newB) & 0x000000ff | (pixel & 0xffffff00);		 //b
                    image.setRGB(x, y, pixel);
                }
            }
            ImageIO.write(image, "jpg", new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /** 
     * @param args 
     */  
    public static void main(String[] args) throws Exception {  
//        int x = 0;  
        ReadColorTest rc = new ReadColorTest();  
//        x = rc.getScreenPixel(100, 345);  
//        System.out.println(x + " - ");  
//        rc.transformGrayJiaQuan("D:\\pictures\\temp\\0.jpg","D:\\pictures\\temp\\transformGrayJiaQuan0.jpg");
//        rc.getImagePixel("D:\\pictures\\temp\\test1.jpg");  
        rc.transformImage("D:\\pictures\\temp\\test2.jpg","D:\\pictures\\temp\\transformImageTest2.jpg");
    
    
     // 调用接口
        int cols = 4;
        int num = 3;
        for(int i=3;i<=num;i++){
        	for (int j = 0; j < cols; j++) {  
        		ReadColorTest rc1 = new ReadColorTest();
        		rc1.transformImage("D:\\pictures\\temp\\test2.jpg","D:\\pictures\\temp\\transformImageTest2.jpg");
        	}  
        }
    
    }  
  
} 
