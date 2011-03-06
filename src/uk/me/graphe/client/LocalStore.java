package uk.me.graphe.client;

import uk.me.graphe.shared.messages.operations.GraphOperation;

public interface LocalStore {

	/**
	 * Add the graph operation to the UnAcked list
	 * 
	 * @param o GraphOperation to be stored
	 */
	void toUnack(GraphOperation o);

	/**
	 * Add the graph operation to the Sent list
	 * 
	 * @param o GraphOperation to be stored
	 */
	void toSent(GraphOperation o);

	/**
	 * Add the graph operation to the Unsent list
	 * 
	 * @param o GraphOperation to be stored
	 */
	void toUnsent(GraphOperation o);

	/**
	 *  Load the state of graph into memory
	 */
	void restore();

	/**
	 *  Save the state of the graph into the serverside database
	 */
	void save();

	/**
	 * Retrieve the collection of operations being stored
	 * 
	 * @return Contained for the three types of storage
	 */
	StorePackage getInformation();

	/**
	 * Save the sent operation into the Store memory
	 * 
	 * @param op GraphOperation to be stored
	 * @param Acked Whether the server has acknowledged receiving the operation 
	 */
	void store(GraphOperation op, boolean Acked);

	/**
	 * Save the unsent operation into the Store memory
	 * @param op GraphOperation to be stored
	 */
	void store(GraphOperation op);

}
