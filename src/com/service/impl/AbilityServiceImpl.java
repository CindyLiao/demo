package com.service.impl;

import java.util.List;

import com.bean.Ability;
import com.dao.AbilityDAO;
import com.service.AbilityService;

public class AbilityServiceImpl implements AbilityService{

	private AbilityDAO abilitydao;
	
	public AbilityDAO getAbilitydao() {
		return abilitydao;
	}

	public void setAbilitydao(AbilityDAO abilitydao) {
		this.abilitydao = abilitydao;
	}

	public void addAbility(Ability ability) {
		abilitydao.save(ability);
	}

	public void updateAbility(Ability ability) {
		abilitydao.attachDirty(ability);
	}

	public void deleteAbility(Ability ability) {
		abilitydao.delete(ability);
	}

	public List findByAbilityName(String abilityname) {
		return abilitydao.findByAbiName(abilityname);
	}

	public List findAll() {
		return abilitydao.findAll();
	}
	
	public Ability findById(int abilityid) {
		return abilitydao.findById(abilityid);
	}
	
	

}
