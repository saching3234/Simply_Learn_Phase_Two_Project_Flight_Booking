package com.services;

import java.util.ArrayList;
import java.util.List;

import com.adminbeans.Source_To_Destination;
import com.dao.Source_To_Destination_Dao;

public class Source_To_Destination_Services {
	Source_To_Destination_Dao dao = new Source_To_Destination_Dao();

	public boolean insertNew_Source_To_Destination_Services(Source_To_Destination bean) {

		return dao.insertSource_To_Destinations(bean);

	}

	public List<Source_To_Destination> getAll_S_To_D() {
		List<Source_To_Destination> list = new ArrayList<Source_To_Destination>();

		list = dao.getAll_Source_To_Destination();
		return list;

	}

	public boolean deletes_d(int sdid) {
		return dao.deleteSource_To_Destinations(sdid);
	}

	public Source_To_Destination edits_d(int sdid) {
		return dao.getSource_To_Destination(sdid);
	}

	public boolean update_Source_To_Destination_Services(Source_To_Destination bean) {

		return dao.changeSource_To_Destinations(bean);
	}

	
}
