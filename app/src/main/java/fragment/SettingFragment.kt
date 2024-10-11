package fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trannguyenthanhduong_2110_bttl.R
import android.widget.RelativeLayout // Thêm dòng này nếu bạn sử dụng RelativeLayout

class SettingFragment : Fragment() {

    // Thay đổi tên biến cho đúng
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        // Tìm nút "Thoát" trong layout (giả sử bạn đã tạo nút trong layout)
        val btnClose: RelativeLayout = view.findViewById(R.id.btn_close) // Thay đổi ID nếu cần

        // Thiết lập OnClickListener cho nút "Thoát"
        btnClose.setOnClickListener {
            activity?.finish() // Đóng ứng dụng
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingFragment().apply { // Sửa tên lớp ở đây
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
