/**
 * 
 */
package by.training.nc.dev5.unit2.dao;

import java.util.Collection;

import by.training.nc.dev5.unit2.model.Training;

/**
 * @author Andrei_Tsishkouski
 *
 */
public class TrainingMySQLDAO implements TrainingDAO {

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.dao.TrainingDAO#deleteTraining(java.lang.String)
	 */
	public boolean deleteTraining(String pTraining) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.dao.TrainingDAO#findTraining(java.lang.String)
	 */
	public Training findTraining(String pTrainingId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.dao.TrainingDAO#insertTraining(by.training.nc.dev5.bean.Training)
	 */
	public int insertTraining(Training pTraining) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.dao.TrainingDAO#selectTrainings()
	 */
	public Collection<Training> selectTrainings() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.dao.TrainingDAO#updateTraining(java.lang.String)
	 */
	public boolean updateTraining(String pTrainingId) {
		// TODO Auto-generated method stub
		return false;
	}

}
