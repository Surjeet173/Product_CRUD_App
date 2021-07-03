package product_crud_app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import product_crud_app.dao.ProductDao;
import product_crud_app.model.Product;

@Controller
public class MainController 
{
	@Autowired
	private ProductDao prdao;
	@RequestMapping("/index")
	public String home(Model m)
	{
		List<Product> pr=prdao.getProducts();
		m.addAttribute("product",pr);
		return "index";
	}
	@RequestMapping("/add-product")
    public String addProduct(Model m)
    {
		m.addAttribute("title","Add Product");
    	return "add_product_form";
    }
	//handle add product form
	@RequestMapping(value="/handle-product",method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest req)
	{
		System.out.println(product);
		this.prdao.createProduct(product);
		RedirectView rd=new RedirectView();
		rd.setUrl(req.getContextPath()+"/"+"index");
		return rd;
	}
	//delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int id, HttpServletRequest req)
	{
		this.prdao.deleteProduct(id);
		RedirectView rd=new RedirectView();
		rd.setUrl(req.getContextPath()+"/"+"index");
		return rd;
	}
	//update handler
		@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int id,Model m)
	{
			Product prd=this.prdao.getProduct(id);
			m.addAttribute("product",prd);
		return "update_form";
	}
}
