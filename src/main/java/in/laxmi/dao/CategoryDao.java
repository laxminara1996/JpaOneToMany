package in.laxmi.dao;

import in.laxmi.entity.CategoryEntity;

public interface CategoryDao {
void saveCategory(CategoryEntity entity); 
CategoryEntity fetchCategory(Integer categoryId);
void removeCategory(Integer categoryId);
}
