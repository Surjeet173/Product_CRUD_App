package product_crud_app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import product_crud_app.model.Product;

@Component
public class ProductDao 
{
	@Autowired
	 private HibernateTemplate ht;
	@Transactional
	public void createProduct(Product product)
	{
		this.ht.saveOrUpdate(product);
	}
    //get all product
	public List<Product> getProducts()
	{
		 List<Product> pr=this.ht.loadAll(Product.class);
		 return pr;
	}
	//delete the single product
	@Transactional
	public void deleteProduct(int pid)
	{
	    Product p=this.ht.load(Product.class,pid);
	    this.ht.delete(p);
	}
	//get the single product
	public Product getProduct(int pid)
	{
		return this.ht.get(Product.class,pid);
	}
}
