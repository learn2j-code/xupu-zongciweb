package com.bjp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBJPTest {
//	@Autowired
//	NavigateBarService navigateBarService;
//	
//	@Test
//	public void testTotal() {
//		Page page = new Page();
//		int count = 6;
//		int num = 1;
//		page.setStart(count*(num-1));
//		page.setCount(count);
//		PageHelper.offsetPage(page.getStart(),page.getCount());
//		List<NavigateBar> navigateBarItemList = navigateBarService.list();
//		int total = (int) new PageInfo<>(navigateBarItemList).getTotal();
//        page.setTotal(total);
//		for(NavigateBar navigateBar:navigateBarItemList){
//			System.out.println("ID："+navigateBar.getNbId());
//			System.out.println("Comments："+navigateBar.getComments());
//			System.out.println("Name："+navigateBar.getNavName());
//			System.out.println("Location："+navigateBar.getNavBitmapLocation());
//		}
//	}
}
