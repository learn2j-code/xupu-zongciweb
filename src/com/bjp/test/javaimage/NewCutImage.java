package com.bjp.test.javaimage;
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.util.ArrayList;  
import java.util.List;  
import javax.imageio.ImageIO;  

/** 
 * 图片切割工具类 
 *  
 * @author Johnson 
 * @version Friday June 10th, 2011 
 */  
public class NewCutImage {  
    /** 
     * 切割图片 
     *  
     * @param sourceFile 
     *            源文件 
     * @param targetDir 
     *            存储目录 
     * @param x 
     *            切片横向起点 
     * @param y 
     *            切片纵向起点 
     * @param width 
     *            切片宽度 
     * @param height 
     *            切片高度 
     * @param cols 
     *            横向切片总数            
     * @param cols 
     *            纵向第几       
     * @return 
     * @throws Exception 
     */  
    public ImageDto cut(File sourceFile, String targetDir, int x, int y, int width, int height, int cols, int num)  
            throws Exception {  
        List<File> list = new ArrayList<File>();  
        BufferedImage source = ImageIO.read(sourceFile);  
        int sWidth = source.getWidth(); // 图片宽度  
        int sHeight = source.getHeight(); // 图片高度  
        if (sWidth > width && sHeight > height) {  
            String fileName = null;  
            File file = new File(targetDir);  
            if (!file.exists()) { // 存储目录不存在，则创建目录  
                file.mkdirs();  
            }  
            BufferedImage image = null;  
            for (int j = 0; j < cols; j++) {  
                // x坐标,y坐标,宽度,高度  
                image = source.getSubimage(x+j * width, y, width,  
                        height);  
                fileName = targetDir + "/map_" + num + "_" + j + ".jpg";  
                file = new File(fileName);  
                ImageIO.write(image, "JPEG", file);  
                list.add(file);  
            }  
        }  
        return new ImageDto(sWidth, sHeight, list);  
    }  
    /** 
     * 切割图片 
     *  
     * @param source 
     *            源文件路径 
     * @param targetDir 
     *            存储目录 
     * @param width 
     *            切片宽度 
     * @param height 
     *            切片高度 
     * @return 
     * @throws Exception 
     */  
    public ImageDto cut(String source, String targetDir, int x, int y, int width, int height, int cols, int num)  
            throws Exception {  
        return cut(new File(source), targetDir, x, y, width, height, cols, num);  
    }  
    
    public static void main(String[] args) throws Exception {
    	NewCutImage cutImage = new NewCutImage();
    	cutImage.cut("D://pictures//temp//test1.jpg", "D://pictures//temp",256,83, 336, 378,6,1);
    	cutImage.cut("D://pictures//temp//test1.jpg", "D://pictures//temp",256,83+378, 336, 527,6,2);
    	cutImage.cut("D://pictures//temp//test1.jpg", "D://pictures//temp",256,83+378+527, 336, 2177,6,3);
	}
}  
