package tw.eeit117.wematch.product.model;

import java.util.List;

public interface IProductBeanService {
	public List<ProductBean> selectAll();

	public String insert(ProductBean productBean);

	public String deleteById(Integer productId);

	public ProductBean findById(Integer productId);
}