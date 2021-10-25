package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.PlacedStudentFeeStructure;
import com.aartek.prestigepoint.repository.PlacedStudentFeeStructureDetailRepository;
import com.aartek.prestigepoint.service.PlacedStudentFeeStructureService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class PlacedStudentFeeStuctureDetailServiceImpl implements PlacedStudentFeeStructureService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(PlacedStudentFeeStuctureDetailServiceImpl.class);

	@Autowired
	private PlacedStudentFeeStructureDetailRepository placedStudentFeeStructureRepository;

	public List<PlacedStudentFeeStructure> getAllPlacedStudentDetail() {
		List<PlacedStudentFeeStructure> placedStudentList = placedStudentFeeStructureRepository
						.getAllPlacedStudentDetail();
		if (placedStudentList != null && !placedStudentList.isEmpty()) {

			return placedStudentList;
		} else
			return null;

	}

	public boolean savePlacedStudentDetail(PlacedStudentFeeStructure placedStudentFeeStructure) {
		{
			boolean status = false;
			if (placedStudentFeeStructure != null) {
				placedStudentFeeStructure.setIsDeleted(IConstant.IS_DELETED);
				status = placedStudentFeeStructureRepository.savePlacedStudentDetail(placedStudentFeeStructure);
			}
			return status;
		}
	}

	public PlacedStudentFeeStructure updatePlacedStudentDetail(Integer placedStudentId) {
		PlacedStudentFeeStructure placedStudentDetail = placedStudentFeeStructureRepository
						.updatePlacedStudentDetail(placedStudentId);
		if (placedStudentDetail != null)
			return placedStudentDetail;
		else
			return null;

	}

	public void deletePlacedStudentDetail(Integer placedStudentId) {
		placedStudentFeeStructureRepository.deletePlacedStudentDetail(placedStudentId);

	}
}
