/**
 * 
 */
package employee.training.dao;

import java.util.Collection;

import employee.training.bean.Training;

/**
 * @author Andrei_Tsishkouski
 *
 */
public class TrainingMySQLDAO implements TrainingDAO {

	/* (non-Javadoc)
	 * @see employee.training.dao.TrainingDAO#deleteTraining(java.lang.String)
	 */
	public boolean deleteTraining(String pTraining) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see employee.training.dao.TrainingDAO#findTraining(java.lang.String)
	 */
	public Training findTraining(String pTrainingId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see employee.training.dao.TrainingDAO#insertTraining(employee.training.bean.Training)
	 */
	public int insertTraining(Training pTraining) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see employee.training.dao.TrainingDAO#selectTrainings()
	 */
	public Collection<Training> selectTrainings() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see employee.training.dao.TrainingDAO#updateTraining(java.lang.String)
	 */
	public boolean updateTraining(String pTrainingId) {
		// TODO Auto-generated method stub
		return false;
	}

}
