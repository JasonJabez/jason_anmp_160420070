package com.example.jason_anmp_160420070.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ModelDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun registerUser(vararg user:User)

    @Query("SELECT * FROM user WHERE id = :id")
    fun fetchByID(id:Int): User

    @Query("SELECT * FROM user WHERE username= :username AND password= :password")
    fun fetchByCreds(username:String, password:String): User

    @Query("UPDATE user SET firstName = :firstName, lastName = :lastName, password = :password WHERE id = :userID")
    fun updateUser(firstName:String, lastName:String, password:String, userID:Int)

    @Query("SELECT * FROM news")
    fun fetchNews(): List<News>

    @Query("SELECT * FROM news WHERE id = :id")
    fun fetchNewsByID(id:Int): News

    @Query("INSERT INTO news (title, author, summary, newsText, newsPicDir) VALUES " +
            "('Orange cat racism', 'Not an Orange', 'Orange cats face persecution..', 'aaa', 'https://cdn.britannica.com/70/234870-050-D4D024BB/Orange-colored-cat-yawns-displaying-teeth.jpg')," +
            "('Black cats: Good or Bad luck?', 'Black Cat Association', 'Black cats are often seen as unlucky. However..', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce interdum pellentesque ligula, at lobortis turpis condimentum vitae. Maecenas in orci porttitor, mollis purus vel, sagittis lacus. Proin magna neque, molestie ac nisl at, pulvinar vestibulum diam. Nullam luctus, metus eget vehicula accumsan, diam nunc convallis odio, et scelerisque elit est ac augue. Suspendisse potenti. Sed vitae augue fermentum diam porta mattis. Pellentesque eget sagittis ante. Suspendisse cursus risus at orci dictum rhoncus. Duis maximus dolor vitae ex suscipit efficitur. Etiam vitae erat ac arcu tempus laoreet eget vel leo. Integer viverra ultricies dapibus. Etiam interdum magna eget cursus dignissim.\\r\\n\\r\\nProin eu fringilla massa, id congue sem. Vestibulum id arcu fringilla, semper est nec, molestie enim. Mauris at justo eget lectus viverra ornare consequat id nibh. Quisque mattis hendrerit luctus. Quisque consectetur, velit ac semper placerat, dolor libero dapibus sem, eget semper risus libero sed dui. Curabitur fermentum justo augue, non tristique nibh rhoncus at. Sed eget sem lobortis, condimentum magna dignissim, placerat neque. Donec volutpat ultricies varius. Duis auctor risus vitae urna euismod, a laoreet justo gravida. Duis eu nulla turpis. Sed non gravida tellus.\\r\\n\\r\\nDonec id dignissim lorem. Maecenas viverra posuere tellus in ornare. Duis ut mi dolor. Aenean consequat imperdiet massa, quis egestas libero. Ut sit amet vulputate libero. Phasellus sed porttitor mi. Proin vestibulum dapibus justo ac commodo. Aenean commodo dignissim ligula, sed finibus nisi hendrerit sit amet.\\r\\n\\r\\nNulla laoreet molestie ligula sed ornare. Praesent id velit eleifend, pharetra dui at, fermentum massa. Donec laoreet laoreet massa nec finibus. Mauris eu risus a metus tempus ultrices at eget mauris. Maecenas a facilisis odio. Maecenas vitae nisi quis nisi dapibus gravida. Praesent turpis ligula, tincidunt a gravida vitae, aliquet quis lectus. Integer diam mi, molestie ac tincidunt a, pulvinar non ex. Nulla euismod tellus a arcu sodales, nec fringilla est imperdiet.\\r\\n\\r\\nNam feugiat porttitor pellentesque. Proin nec venenatis turpis. Sed ut nisl ornare, suscipit nisi sit amet, efficitur eros. Suspendisse finibus tellus consequat lectus malesuada, ac laoreet lorem placerat. Vestibulum eget feugiat diam, in blandit ex. Pellentesque fermentum sem eu ipsum porta fringilla. In euismod erat efficitur consequat molestie. Proin a scelerisque nulla, sed porttitor massa. Aenean in nisi leo. Cras vitae consectetur lacus. Donec tempor tristique magna, posuere vestibulum lorem elementum in. Sed viverra maximus dolor, ac faucibus nibh condimentum et. Donec aliquet leo eros, nec suscipit mauris mattis molestie. ', 'https://upload.wikimedia.org/wikipedia/commons/4/4c/Blackcat-Lilith.jpg'), " +
            "('Life for old strays', 'Straffordshire Shelter', 'Old cats are very rarely seen in the wild, due to the many..', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce interdum pellentesque ligula, at lobortis turpis condimentum vitae. Maecenas in orci porttitor, mollis purus vel, sagittis lacus. Proin magna neque, molestie ac nisl at, pulvinar vestibulum diam. Nullam luctus, metus eget vehicula accumsan, diam nunc convallis odio, et scelerisque elit est ac augue. Suspendisse potenti. Sed vitae augue fermentum diam porta mattis. Pellentesque eget sagittis ante. Suspendisse cursus risus at orci dictum rhoncus. Duis maximus dolor vitae ex suscipit efficitur. Etiam vitae erat ac arcu tempus laoreet eget vel leo. Integer viverra ultricies dapibus. Etiam interdum magna eget cursus dignissim.\\r\\n\\r\\nProin eu fringilla massa, id congue sem. Vestibulum id arcu fringilla, semper est nec, molestie enim. Mauris at justo eget lectus viverra ornare consequat id nibh. Quisque mattis hendrerit luctus. Quisque consectetur, velit ac semper placerat, dolor libero dapibus sem, eget semper risus libero sed dui. Curabitur fermentum justo augue, non tristique nibh rhoncus at. Sed eget sem lobortis, condimentum magna dignissim, placerat neque. Donec volutpat ultricies varius. Duis auctor risus vitae urna euismod, a laoreet justo gravida. Duis eu nulla turpis. Sed non gravida tellus.\\r\\n\\r\\nDonec id dignissim lorem. Maecenas viverra posuere tellus in ornare. Duis ut mi dolor. Aenean consequat imperdiet massa, quis egestas libero. Ut sit amet vulputate libero. Phasellus sed porttitor mi. Proin vestibulum dapibus justo ac commodo. Aenean commodo dignissim ligula, sed finibus nisi hendrerit sit amet.\\r\\n\\r\\nNulla laoreet molestie ligula sed ornare. Praesent id velit eleifend, pharetra dui at, fermentum massa. Donec laoreet laoreet massa nec finibus. Mauris eu risus a metus tempus ultrices at eget mauris. Maecenas a facilisis odio. Maecenas vitae nisi quis nisi dapibus gravida. Praesent turpis ligula, tincidunt a gravida vitae, aliquet quis lectus. Integer diam mi, molestie ac tincidunt a, pulvinar non ex. Nulla euismod tellus a arcu sodales, nec fringilla est imperdiet.\\r\\n\\r\\nNam feugiat porttitor pellentesque. Proin nec venenatis turpis. Sed ut nisl ornare, suscipit nisi sit amet, efficitur eros. Suspendisse finibus tellus consequat lectus malesuada, ac laoreet lorem placerat. Vestibulum eget feugiat diam, in blandit ex. Pellentesque fermentum sem eu ipsum porta fringilla. In euismod erat efficitur consequat molestie. Proin a scelerisque nulla, sed porttitor massa. Aenean in nisi leo. Cras vitae consectetur lacus. Donec tempor tristique magna, posuere vestibulum lorem elementum in. Sed viverra maximus dolor, ac faucibus nibh condimentum et. Donec aliquet leo eros, nec suscipit mauris mattis molestie. ', 'https://ichef.bbci.co.uk/news/976/cpsprodpb/24BE/production/_123760490_mediaitem123760488.jpg'), " +
            "('The Male Calico', 'Calicats, Inc.', 'While nearly all calico cats are female, some male calico cats may exist. This is due to..', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce interdum pellentesque ligula, at lobortis turpis condimentum vitae. Maecenas in orci porttitor, mollis purus vel, sagittis lacus. Proin magna neque, molestie ac nisl at, pulvinar vestibulum diam. Nullam luctus, metus eget vehicula accumsan, diam nunc convallis odio, et scelerisque elit est ac augue. Suspendisse potenti. Sed vitae augue fermentum diam porta mattis. Pellentesque eget sagittis ante. Suspendisse cursus risus at orci dictum rhoncus. Duis maximus dolor vitae ex suscipit efficitur. Etiam vitae erat ac arcu tempus laoreet eget vel leo. Integer viverra ultricies dapibus. Etiam interdum magna eget cursus dignissim.\\r\\n\\r\\nProin eu fringilla massa, id congue sem. Vestibulum id arcu fringilla, semper est nec, molestie enim. Mauris at justo eget lectus viverra ornare consequat id nibh. Quisque mattis hendrerit luctus. Quisque consectetur, velit ac semper placerat, dolor libero dapibus sem, eget semper risus libero sed dui. Curabitur fermentum justo augue, non tristique nibh rhoncus at. Sed eget sem lobortis, condimentum magna dignissim, placerat neque. Donec volutpat ultricies varius. Duis auctor risus vitae urna euismod, a laoreet justo gravida. Duis eu nulla turpis. Sed non gravida tellus.\\r\\n\\r\\nDonec id dignissim lorem. Maecenas viverra posuere tellus in ornare. Duis ut mi dolor. Aenean consequat imperdiet massa, quis egestas libero. Ut sit amet vulputate libero. Phasellus sed porttitor mi. Proin vestibulum dapibus justo ac commodo. Aenean commodo dignissim ligula, sed finibus nisi hendrerit sit amet.\\r\\n\\r\\nNulla laoreet molestie ligula sed ornare. Praesent id velit eleifend, pharetra dui at, fermentum massa. Donec laoreet laoreet massa nec finibus. Mauris eu risus a metus tempus ultrices at eget mauris. Maecenas a facilisis odio. Maecenas vitae nisi quis nisi dapibus gravida. Praesent turpis ligula, tincidunt a gravida vitae, aliquet quis lectus. Integer diam mi, molestie ac tincidunt a, pulvinar non ex. Nulla euismod tellus a arcu sodales, nec fringilla est imperdiet.\\r\\n\\r\\nNam feugiat porttitor pellentesque. Proin nec venenatis turpis. Sed ut nisl ornare, suscipit nisi sit amet, efficitur eros. Suspendisse finibus tellus consequat lectus malesuada, ac laoreet lorem placerat. Vestibulum eget feugiat diam, in blandit ex. Pellentesque fermentum sem eu ipsum porta fringilla. In euismod erat efficitur consequat molestie. Proin a scelerisque nulla, sed porttitor massa. Aenean in nisi leo. Cras vitae consectetur lacus. Donec tempor tristique magna, posuere vestibulum lorem elementum in. Sed viverra maximus dolor, ac faucibus nibh condimentum et. Donec aliquet leo eros, nec suscipit mauris mattis molestie. ', 'https://www.catster.com/wp-content/uploads/2018/03/Calico-cat.jpg'), " +
            "('Why do white cats often have two different eye colors?', 'Harvard University', 'White cats are commonly seen with two differing eye colors. Research has shown that..', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce interdum pellentesque ligula, at lobortis turpis condimentum vitae. Maecenas in orci porttitor, mollis purus vel, sagittis lacus. Proin magna neque, molestie ac nisl at, pulvinar vestibulum diam. Nullam luctus, metus eget vehicula accumsan, diam nunc convallis odio, et scelerisque elit est ac augue. Suspendisse potenti. Sed vitae augue fermentum diam porta mattis. Pellentesque eget sagittis ante. Suspendisse cursus risus at orci dictum rhoncus. Duis maximus dolor vitae ex suscipit efficitur. Etiam vitae erat ac arcu tempus laoreet eget vel leo. Integer viverra ultricies dapibus. Etiam interdum magna eget cursus dignissim.\\r\\n\\r\\nProin eu fringilla massa, id congue sem. Vestibulum id arcu fringilla, semper est nec, molestie enim. Mauris at justo eget lectus viverra ornare consequat id nibh. Quisque mattis hendrerit luctus. Quisque consectetur, velit ac semper placerat, dolor libero dapibus sem, eget semper risus libero sed dui. Curabitur fermentum justo augue, non tristique nibh rhoncus at. Sed eget sem lobortis, condimentum magna dignissim, placerat neque. Donec volutpat ultricies varius. Duis auctor risus vitae urna euismod, a laoreet justo gravida. Duis eu nulla turpis. Sed non gravida tellus.\\r\\n\\r\\nDonec id dignissim lorem. Maecenas viverra posuere tellus in ornare. Duis ut mi dolor. Aenean consequat imperdiet massa, quis egestas libero. Ut sit amet vulputate libero. Phasellus sed porttitor mi. Proin vestibulum dapibus justo ac commodo. Aenean commodo dignissim ligula, sed finibus nisi hendrerit sit amet.\\r\\n\\r\\nNulla laoreet molestie ligula sed ornare. Praesent id velit eleifend, pharetra dui at, fermentum massa. Donec laoreet laoreet massa nec finibus. Mauris eu risus a metus tempus ultrices at eget mauris. Maecenas a facilisis odio. Maecenas vitae nisi quis nisi dapibus gravida. Praesent turpis ligula, tincidunt a gravida vitae, aliquet quis lectus. Integer diam mi, molestie ac tincidunt a, pulvinar non ex. Nulla euismod tellus a arcu sodales, nec fringilla est imperdiet.\\r\\n\\r\\nNam feugiat porttitor pellentesque. Proin nec venenatis turpis. Sed ut nisl ornare, suscipit nisi sit amet, efficitur eros. Suspendisse finibus tellus consequat lectus malesuada, ac laoreet lorem placerat. Vestibulum eget feugiat diam, in blandit ex. Pellentesque fermentum sem eu ipsum porta fringilla. In euismod erat efficitur consequat molestie. Proin a scelerisque nulla, sed porttitor massa. Aenean in nisi leo. Cras vitae consectetur lacus. Donec tempor tristique magna, posuere vestibulum lorem elementum in. Sed viverra maximus dolor, ac faucibus nibh condimentum et. Donec aliquet leo eros, nec suscipit mauris mattis molestie. ', 'https://www.rover.com/blog/wp-content/uploads/white-cat-min.jpg'), " +
            "('When is it right to separate kittens?', 'The Cat Breeding Association', 'It is often hard to gauge the difference between the kitten and adolescent phase in cat development. However..', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce interdum pellentesque ligula, at lobortis turpis condimentum vitae. Maecenas in orci porttitor, mollis purus vel, sagittis lacus. Proin magna neque, molestie ac nisl at, pulvinar vestibulum diam. Nullam luctus, metus eget vehicula accumsan, diam nunc convallis odio, et scelerisque elit est ac augue. Suspendisse potenti. Sed vitae augue fermentum diam porta mattis. Pellentesque eget sagittis ante. Suspendisse cursus risus at orci dictum rhoncus. Duis maximus dolor vitae ex suscipit efficitur. Etiam vitae erat ac arcu tempus laoreet eget vel leo. Integer viverra ultricies dapibus. Etiam interdum magna eget cursus dignissim.\\r\\n\\r\\nProin eu fringilla massa, id congue sem. Vestibulum id arcu fringilla, semper est nec, molestie enim. Mauris at justo eget lectus viverra ornare consequat id nibh. Quisque mattis hendrerit luctus. Quisque consectetur, velit ac semper placerat, dolor libero dapibus sem, eget semper risus libero sed dui. Curabitur fermentum justo augue, non tristique nibh rhoncus at. Sed eget sem lobortis, condimentum magna dignissim, placerat neque. Donec volutpat ultricies varius. Duis auctor risus vitae urna euismod, a laoreet justo gravida. Duis eu nulla turpis. Sed non gravida tellus.\\r\\n\\r\\nDonec id dignissim lorem. Maecenas viverra posuere tellus in ornare. Duis ut mi dolor. Aenean consequat imperdiet massa, quis egestas libero. Ut sit amet vulputate libero. Phasellus sed porttitor mi. Proin vestibulum dapibus justo ac commodo. Aenean commodo dignissim ligula, sed finibus nisi hendrerit sit amet.\\r\\n\\r\\nNulla laoreet molestie ligula sed ornare. Praesent id velit eleifend, pharetra dui at, fermentum massa. Donec laoreet laoreet massa nec finibus. Mauris eu risus a metus tempus ultrices at eget mauris. Maecenas a facilisis odio. Maecenas vitae nisi quis nisi dapibus gravida. Praesent turpis ligula, tincidunt a gravida vitae, aliquet quis lectus. Integer diam mi, molestie ac tincidunt a, pulvinar non ex. Nulla euismod tellus a arcu sodales, nec fringilla est imperdiet.\\r\\n\\r\\nNam feugiat porttitor pellentesque. Proin nec venenatis turpis. Sed ut nisl ornare, suscipit nisi sit amet, efficitur eros. Suspendisse finibus tellus consequat lectus malesuada, ac laoreet lorem placerat. Vestibulum eget feugiat diam, in blandit ex. Pellentesque fermentum sem eu ipsum porta fringilla. In euismod erat efficitur consequat molestie. Proin a scelerisque nulla, sed porttitor massa. Aenean in nisi leo. Cras vitae consectetur lacus. Donec tempor tristique magna, posuere vestibulum lorem elementum in. Sed viverra maximus dolor, ac faucibus nibh condimentum et. Donec aliquet leo eros, nec suscipit mauris mattis molestie. ', 'https://upload.wikimedia.org/wikipedia/commons/b/bc/Juvenile_Ragdoll.jpg')"
    )
    fun addNews()

    @Query("DELETE FROM news")
    fun nukeNews()
}