package menu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import fragment.MenuFragment;
import fragment.ProfileFragment;
import fragment.SettingFragment;

public class MenuViewPagerAdapter extends FragmentStatePagerAdapter {
    public MenuViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tad1Fragment();

            case 1:
                return new Tad2Fragment();

            case 2:
                return new Tad3Fragment();

            default:
                return new Tad1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Tên sinh viên";

            case 1:
                return "Mã sinh viên";

            case 2:
                return "Lớp học phần";
            default:
                return "Tên sinh viên";
        }
    }
}
