package by.training.nc.dev5.unit2.dao;

import java.util.Collection;

import by.training.nc.dev5.unit2.model.Training;

public interface TrainingDAO {
	  int insertTraining(Training pTraining);
	  boolean deleteTraining(String pTraining);
	  Training findTraining(String pTrainingId);
	  boolean updateTraining(String pTrainingId);
	  Collection<Training> selectTrainings();
}
