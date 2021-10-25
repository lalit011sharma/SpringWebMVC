package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.PlacedStudentFeeStructure;
import com.aartek.prestigepoint.repository.PlacedStudentFeeStructureDetailRepository;
import com.aartek.prestigepoint.util.IConstant;

@Repository
public class PlacedStudentFeeStructureDetailRepositoryImpl implements PlacedStudentFeeStructureDetailRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<PlacedStudentFeeStructure> getAllPlacedStudentDetail() {
		@SuppressWarnings("unchecked")
		List<PlacedStudentFeeStructure> placedStudentList = hibernateTemplate
				.find("from PlacedStudentFeeStructure pa where pa.isDeleted=" + IConstant.IS_DELETED);

		return placedStudentList;
	}

	public boolean savePlacedStudentDetail(PlacedStudentFeeStructure placedStudentFeeStructure) {
		if (placedStudentFeeStructure != null) {
			hibernateTemplate.saveOrUpdate(placedStudentFeeStructure);
			return true;
		}
		return false;
	}

	public PlacedStudentFeeStructure updatePlacedStudentDetail(Integer placedStudentId) {
		PlacedStudentFeeStructure placedStudentDetails = hibernateTemplate.get(PlacedStudentFeeStructure.class,placedStudentId);
		return placedStudentDetails;

	}

	public void deletePlacedStudentDetail(Integer placedStudentId) {
		PlacedStudentFeeStructure placedStudentFeeStructure = hibernateTemplate.get(PlacedStudentFeeStructure.class,
				placedStudentId);
		placedStudentFeeStructure.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		hibernateTemplate.update(placedStudentFeeStructure);

	}
}
