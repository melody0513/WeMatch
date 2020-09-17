package tw.eeit117.wematch.product.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductBean {
	private Integer productId;
	private String category;
	private String productName;
	private Double price;
	private Integer stock;
	private String productDescription;
	private byte[] thumbnail;
	private byte[] detailImg;

	public ProductBean() {
	}

	public ProductBean(String category, String productName, Double price, Integer stock, String productDescription,
			byte[] thumbnail, byte[] detailImg) {
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.productDescription = productDescription;
		this.thumbnail = thumbnail;
		this.detailImg = detailImg;
	}

	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "productName")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "stock")
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Column(name = "productDescription")
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Column(name = "thumbnail")
	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Column(name = "detailImg")
	public byte[] getDetailImg() {
		return detailImg;
	}

	public void setDetailImg(byte[] detailImg) {
		this.detailImg = detailImg;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", category=" + category + ", productName=" + productName
				+ ", price=" + price + ", stock=" + stock + ", productDescription=" + productDescription
				+ ", thumbnail=" + Arrays.toString(thumbnail) + ", detailImg=" + Arrays.toString(detailImg) + "]";
	}

}