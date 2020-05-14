package com.youcode.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.config.AuditModel;
import com.youcode.enums.StarsAttributeName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "stars_collections")
public class StarsCollection extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@OneToOne(mappedBy = "stars_collection")
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ElementCollection
	@Column(name = "stars")
	private Map<StarsAttributeName , Integer> stars_data = new HashMap<>();
	
	@JsonIgnore
	@Transient
	private float rating;
	
//	@PrePersist
//	void prePersist() {
//		if(this.stars_data==null) {
//			
//		}
//	}
	
	StarsCollection(){
		this.stars_data = new HashMap<StarsAttributeName, Integer>();
		this.stars_data.put(StarsAttributeName.STAR_1, 0);
		this.stars_data.put(StarsAttributeName.STAR_2, 0);
		this.stars_data.put(StarsAttributeName.STAR_3, 0);
		this.stars_data.put(StarsAttributeName.STAR_4, 0);
		this.stars_data.put(StarsAttributeName.STAR_5, 0);
	}
//	
	public void incStars(int review_stars) {
			switch (review_stars) {
			case 1:
				this.stars_data.put(StarsAttributeName.STAR_1, this.stars_data.get(StarsAttributeName.STAR_1) + 1);
				break;
			case 2:
				this.stars_data.put(StarsAttributeName.STAR_2, this.stars_data.get(StarsAttributeName.STAR_2) + 1);
				break;
			case 3:
				this.stars_data.put(StarsAttributeName.STAR_3, this.stars_data.get(StarsAttributeName.STAR_3) + 1);
				break;
			case 4:
				this.stars_data.put(StarsAttributeName.STAR_4, this.stars_data.get(StarsAttributeName.STAR_4) + 1);
				break;
			case 5:
				this.stars_data.put(StarsAttributeName.STAR_5, this.stars_data.get(StarsAttributeName.STAR_5) + 1);
				break;

			default:
				System.out.println("there is a prb in the switch");
				break;
			}
	}
//	
	public float calc_rating() {
		int sum = this.stars_data.get(StarsAttributeName.STAR_1)+this.stars_data.get(StarsAttributeName.STAR_2)+this.stars_data.get(StarsAttributeName.STAR_3)+this.stars_data.get(StarsAttributeName.STAR_4)+this.stars_data.get(StarsAttributeName.STAR_5);
		if(sum==0) return 0;
		float rating = (5*this.stars_data.get(StarsAttributeName.STAR_5) + 4*this.stars_data.get(StarsAttributeName.STAR_4) + 3*this.stars_data.get(StarsAttributeName.STAR_3) + 2*this.stars_data.get(StarsAttributeName.STAR_2) + 1*this.stars_data.get(StarsAttributeName.STAR_1)) / sum;
		this.rating = rating;
		return rating;
	}
	
	public float getRating() {
		return calc_rating();
	}
}
