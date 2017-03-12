package employee.training.dao;

import java.util.Collection;

import employee.training.bean.Training;

public interface TrainingDAO {
	  public int insertTraining(Training pTraining);
	  public boolean deleteTraining(String pTraining);
	  public Training findTraining(String pTrainingId);
	  public boolean updateTraining(String pTrainingId);
	  public Collection<Training> selectTrainings();
}
