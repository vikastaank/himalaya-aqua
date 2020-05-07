package com.himalaya.aqua.aqua.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "subcategories")
public class SubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "CategoryId")
	@ManyToOne
	private Category category;

	@Column(name = "Name")
	private String name;

	@Column(name = "Status")
	private String status;

	@Column(name = "ShortDesc")
	private String shortDesc;

	@Column(name = "LongDesc")
	private String longDesc;

	@Column(name = "ImageUrl")
	private String imageUrl;
}