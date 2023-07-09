package com.product.recommendation.dao;

import com.product.recommendation.model.Theme;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeDaoService {

    @Autowired
    private List<Theme> themes;

    // NOTE:
    // The dummy data is used from the CSV file
    // Incase of relational database being used, Below is the query for retrieval
    // SELECT * FROM themes WHERE ID in (ids);
    // The ID primary key indexed by default
    public List<Theme> fetchThemeByIds(List<Integer> ids) {
        List<Theme> matchedThemes = new ArrayList<>();
        for (Theme theme : themes) {
            if (ids.indexOf(theme.getId()) > -1) {
                matchedThemes.add(theme);
            }
        }
        return matchedThemes;
    }

    // NOTE:
    // The dummy data is used from the CSV file
    // Incase of relational database being used, Below is the query for retrieval
    // SELECT * FROM themes WHERE ID NOT IN (ids) LIMIT size;
    // The ID primary key indexed by default & limit is used to get only required data
    public List<Theme> collectRandomThemes(List<Integer> ids, Integer size) {
        List<Theme> randomThemes = new ArrayList<>();
        for (Theme theme : themes) {
            if (ids.indexOf(theme.getId()) < 0) {
                randomThemes.add(theme);
            }
            if (randomThemes.size() == size) return randomThemes;
        }
        return randomThemes;
    }
}
