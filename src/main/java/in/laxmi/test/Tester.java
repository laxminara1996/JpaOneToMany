package in.laxmi.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import in.laxmi.dao.CategoryDao;
import in.laxmi.dao.impl.CategoryDaoImpl;
import in.laxmi.entity.CategoryEntity;
import in.laxmi.entity.ProductEntity;

public class Tester {
public static void main(String[] args) throws IOException {
	
	CategoryDao dao = new CategoryDaoImpl();
	CategoryEntity ce = new CategoryEntity();
	ce.setCategoryId(12101);
	ce.setCategoryName("electronics");
	
	ProductEntity pe1 = new ProductEntity();
	pe1.setProductId(1);
	pe1.setProductName("mobile");
	File file = new File("C:\\images\\mobile1.jpg");
    byte[]	imageBytes = new byte[(int)file.length()];
    FileInputStream fis = new FileInputStream(file);
    fis.read(imageBytes);
		pe1.setProductImage(imageBytes);
		
		ProductEntity pe2 = new ProductEntity();
		pe2.setProductId(2);
		pe2.setProductName("mobile1");
		File file1 = new File("C:\\images\\mobile2.jpg");
	    byte[]	imageBytes1 = new byte[(int)file1.length()];
	    FileInputStream fis1 = new FileInputStream(file1);
	    fis1.read(imageBytes1);
			pe2.setProductImage(imageBytes1);
			List<ProductEntity> lstofroducts = Arrays.asList(pe1,pe2);
			ce.setListofProducts(lstofroducts);
			dao.saveCategory(ce);
}
}
