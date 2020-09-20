package tw.eeit117.wematch.product.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:TableName.properties")
public class ProductBeanDAO implements IProductBeanDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Value("${productTablePersistentClassName}")
	private String productPersistentClass;

	@Value("${CURE_STATE_SUCCESS}")
	private String CURE_STATE_SUCCESS;

	@Value("${CURE_STATE_REPEATED}")
	private String CURE_STATE_REPEATED;

	@Override
	public List<ProductBean> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM " + productPersistentClass, ProductBean.class).list();
	}

	@Override
	public String insert(ProductBean productBean) {
		Session session = sessionFactory.getCurrentSession();
//		ProductBean product = session.get(ProductBean.class, productBean.getProductId());
//		ProductBean product = null;
		String insertState = "";
//		if (product == null) {
		try {
			session.save(productBean);
			insertState = CURE_STATE_SUCCESS;
		} catch (Exception e) {
			insertState = e.getMessage();
		}
		return insertState;
//		}
//		insertState = CURE_STATE_REPEATED;
//		return insertState;
	}

	@Override
	public String deleteById(Integer productId) {
		Session session = sessionFactory.getCurrentSession();
		ProductBean productBean = session.byId(ProductBean.class).load(productId);
		session.delete(productBean);
		return null;
	}

	@Override
	public ProductBean findById(Integer productId) {
		Session session = sessionFactory.getCurrentSession();
		return session.byId(ProductBean.class).load(productId);
	}

}