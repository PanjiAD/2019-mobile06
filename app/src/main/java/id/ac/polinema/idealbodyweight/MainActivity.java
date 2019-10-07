
package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.fragments.BodyMassIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.fragments.ResultFragment;

public class MainActivity extends AppCompatActivity implements
		MenuFragment.OnFragmentInteractionListener,
		BrocaIndexFragment.OnFragmentInteractionListener,
        ResultFragment.OnFragmentInteractionListener,
        BodyMassIndexFragment.OnFragmentInteractionListener {

    // Deklarasikan atribut Fragment di sini
	private AboutFragment aboutfFragment;
	private MenuFragment menuFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private BodyMassIndexFragment bodyMassIndexFragment;
	private ResultFragment resultFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		aboutfFragment = AboutFragment.newInstance("Panji Awwaludi D");
		menuFragment = new MenuFragment();

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();

		brocaIndexFragment = new BrocaIndexFragment();
		bodyMassIndexFragment = new BodyMassIndexFragment();
		resultFragment = new ResultFragment();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		if (item.getItemId() == R.id.menu_about){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, aboutfFragment)
					.addToBackStack(null)
					.commit();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, bodyMassIndexFragment)
                .commit();
	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
        resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, resultFragment, "BrocaIndexFragment")
                .commit();
	}

    @Override
    public void onTryAgainButtonClicked(String tag) {
		if (tag.equals("BrocaIndexFragment")){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, brocaIndexFragment)
					.commit();
		} else if (tag.equals("BodyMassIndexFragment")) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, bodyMassIndexFragment)
					.commit();
		}
    }

    @Override
    public void onClaculateBodyMassIndexClicked(float index) {
        resultFragment.setInformation(String.format("Your body mass is %.2f kg", index));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, resultFragment,"BodyMassIndexFragment")
                .commit();
    }
}
