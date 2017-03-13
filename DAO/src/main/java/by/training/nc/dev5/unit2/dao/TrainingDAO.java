package by.training.nc.dev5.unit2.dao;

import java.util.Collection;

import by.training.nc.dev5.unit2.model.Training;

public interface TrainingDAO {
	  public int insertTraining(Training pTraining);
	  public boolean deleteTraining(String pTraining);
	  public Training findTraining(String pTrainingId);
	  public boolean updateTraining(String pTrainingId);
	  public Collection<Training> selectTrainings();
}
