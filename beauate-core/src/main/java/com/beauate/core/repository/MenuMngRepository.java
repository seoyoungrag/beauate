package com.beauate.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.beauate.core.entity.MenuMng;

@RepositoryRestResource(collectionResourceRel = "menuMng", path = "menuMng")
public interface MenuMngRepository extends JpaRepository<MenuMng,Integer>{
	@Query(
			  value = "with recursive cte as (" + 
			  		" select menu_id, " + 
			  		" upper_menu_id, " + 
			  		" menu_lv," + 
			  		" menu_sort," + 
			  		" menu_nm, " + 
			  		" prgr_id," + 
			  		" menu_se," + 
			  		" menu_cn," + 
			  		" extrl_url," + 
			  		" use_yn," + 
			  		" reg_id," + 
			  		" reg_de," +
			  		" updt_id," + 
			  		" updt_de" + 
			  		" from menu_mng where upper_menu_id = 0" + 
			  		" union all " + 
			  		" select p.menu_id, " + 
			  		" p.upper_menu_id, " +  
			  		" p.menu_lv," + 
			  		" p.menu_sort," + 
			  		" p.menu_nm, " + 
			  		" p.prgr_id," + 
			  		" p.menu_se," + 
			  		" p.menu_cn," + 
			  		" p.extrl_url," + 
			  		" p.use_yn," + 
			  		" p.reg_id," + 
			  		" p.reg_de," + 
			  		" p.updt_id," + 
			  		" p.updt_de" + 
			  		" from menu_mng p inner join cte on p.upper_menu_id = cte.menu_id ) " + 
			  		" select menu_id,ifnull( upper_menu_id, 0) as pidx, menu_nm, menu_lv, menu_sort," + 
			  		" prgr_id," + 
			  		" menu_se," + 
			  		" menu_cn," + 
			  		" extrl_url," + 
			  		" upper_menu_id," + 
			  		" use_yn," + 
			  		" reg_id," + 
			  		" reg_de," + 
			  		" updt_id," + 
			  		" updt_de from cte ", 
			  nativeQuery = true)
	List<MenuMng> selectMenuList();
}
