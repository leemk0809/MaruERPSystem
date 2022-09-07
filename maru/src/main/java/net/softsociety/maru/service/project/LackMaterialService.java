package net.softsociety.maru.service.project;

import java.util.List;

import net.softsociety.maru.domain.NeedMaterial;

public interface LackMaterialService {
	List<NeedMaterial> selectAllLackMaterial();
}
